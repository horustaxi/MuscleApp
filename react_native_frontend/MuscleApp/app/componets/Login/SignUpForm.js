import React from 'react';
import { Image, View, Text, AsyncStorage, Alert } from 'react-native';
import axios from 'axios';
import { VButton, Card, CardSection, Input, TextButton } from '../Common';
import styles from './styles';
import { Constants } from '../../config/constants';

class LoginForm extends React.PureComponent {

  state = { email: '', password: '' };
  
  static navigationOptions = {
      title: 'Login',
  };

  login = () => {
    axios.post(`${Constants.apiUrl}login`, {
        email: this.state.email.trim(),
        password: this.state.password
      })
      .then(async (response) => {
        console.log(response.status);
        if (response.headers.authorization) {
          try {
            console.log('storing token');
            AsyncStorage.setItem('@MuscleApp:token', response.headers.authorization)
            .then(() =>
              console.log('token stored')
            );
            Alert.alert('You are Logged In');
          } catch (error) {
            console.error(`0 ${response}`);
            Alert.alert('Error', 'Oops! Something happened. Please try again');
          }
        } else {
          console.log(`1 ${response}`);
          Alert.alert('Error', 'Oops! Something happened. Please try again');
        }
      })
      .catch(response => {
        try {
          if (response.response.status == '403') {
            Alert.alert('Error', 'Password or Email may be wrong. Please try again.');
          } else {
            Alert.alert('Error', `${response.response.status} - Oops! Something happened. Please try again.`);
          }
        } catch (error) {
          Alert.alert('Error', 'Unavailable Server. Please try again.');
        }
      });
  }

  render() {
    return (
      <View>
        <Card>
          <CardSection>
            <View style={styles.logoContainer}>
              <Image
                  source={require('../../images/muscleapp_launch_icon.png')}
                  style={styles.logo}
              />
              <Text style={styles.title}>Let's work out!</Text>
            </View>
          </CardSection>
          <CardSection>
            <Input
              placeholder="user@email.com"
              label="Email"
              value={this.state.email}
              onChangeText={email => this.setState({ email })}
            />
          </CardSection>

          <CardSection>
            <Input
              placeholder="password"
              label="Password"
              value={this.state.password}
              onChangeText={password => this.setState({ password })}
              secureTextEntry
            />
          </CardSection>

          <CardSection>
          <VButton onPress={this.login}>Login</VButton>
          </CardSection>
        </Card>

        <View style={styles.newAccountContainer}>
          <TextButton
            textStyle={{ color: 'blue' }}
            text="I don't have an account..."
            onPress={() => Alert.alert('New acount!')}
          />
        </View>
      </View>
    );
  }
}

export default LoginForm;
