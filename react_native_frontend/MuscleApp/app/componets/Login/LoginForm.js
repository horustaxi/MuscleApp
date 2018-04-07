import React from 'react';
import { Image, View, Text, AsyncStorage, Alert } from 'react-native';
import axios from 'axios';
import { VButton, Card, CardSection, Input, TextButton, Spinner } from '../Common';
import styles from './styles';
import { Constants } from '../../config/constants';

class LoginForm extends React.PureComponent {
  
  static navigationOptions = {
      title: 'Login',
  };

  constructor(props) {
    super(props);

    this.onLoginSuccess = this.onLoginSuccess.bind(this);
    this.onLoginFail = this.onLoginFail.bind(this);
  }


  state = { email: '', password: '', error: '', loading: false };

  onLoginSuccess(token) {
    try {
      console.log('storing token');
      AsyncStorage.setItem('@MuscleApp:token', token)
        .then(() =>
          console.log('token stored')
        );
      Alert.alert('You are Logged In');
      this.setState({ email: '', password: '', loading: false });
      this.props.navigation.navigate('Exercises');
    } catch (error) {
      console.error(`${error}`);
      Alert.alert('Error', 'Oops! Something gone wrong.');
    }
  }

  onLoginFail(response) {
    try {
      if (response.response.status == '403') {
        this.setState({ error: 'Wrong Password or Email.', email: '', password: '', loading: false });
      } else {
        Alert.alert('Error', `${response.response.status} - Oops! Something gone wrong.`);
      }
    } catch (error) {
      this.setState({ error: 'Unavailable Server. Please try again.', loading: false });
    }
  }

  login = () => {
    this.setState({ error: '', loading: true });

    axios.post(`${Constants.apiUrl}login`, {
        email: this.state.email.trim(),
        password: this.state.password
      })
      .then(async (response) => {
        console.log(response.status);
        if (response.headers.authorization) {
          this.onLoginSuccess(response.headers.authorization);
        } else {
          console.log(`${response}`);
          Alert.alert('Error', 'Oops! Something gone wrong.');
        }
      })
      .catch(response => {
        this.onLoginFail(response);
      });
  }

  renderButton() {
    if (this.state.loading) {
      return <Spinner size="large" />;
    }

    return (
      <VButton onPress={this.login}>Login</VButton>
    );
  }

  render() {
    return (
      <View style={{ flex: 1 }}>
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

          <Text style={styles.erroTextStyle}>
            {this.state.error}
          </Text>

          <CardSection>
            {this.renderButton()}
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
