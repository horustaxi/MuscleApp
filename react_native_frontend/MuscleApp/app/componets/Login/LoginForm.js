import React from 'react';
import { TextInput, View, AsyncStorage, Alert } from 'react-native';
import axios from 'axios';
import styles from './styles';
import { Constants } from '../../config/constants';
import VButton from '../VButton/index';

export class LoginForm extends React.PureComponent {

  constructor(props) {
    super(props);
    this.state = { email: '', password: '' };
  }

  login = () => {
    axios.post(`${Constants.apiUrl}login`, {
        email: this.state.email.trim(),
        password: this.state.password
      })
      .then(async (response) => {
        console.log(response.headers.authorization);
        if (response.headers.authorization) {
          try {
            console.log('storing token');
            AsyncStorage.setItem('@MuscleApp:token', response.headers.authorization)
            .then(() =>
              console.log('token stored')
            );
            Alert.alert('You are Logged In');
          } catch (error) {
            console.error(error);
            Alert.alert('Error', 'Oops! Something happened. Please try again');
          }
        } else {
          Alert.alert('Error', 'Oops! Something happened. Please try again');
        }
      })
      .catch(response => {
        console.error(response);
        Alert.alert('Error', 'Oops! Something happened. Please try again');
      });
  }

  render() {
    return (
      <View style={styles.container}>
        <TextInput
          placeholder="email"
          placeholderTextColor="grey"
          style={styles.input}
          value={this.state.email}
          onChangeText={(email) => this.setState({ email })}
        />
        <TextInput
          placeholder="password"
          placeholderTextColor="grey"
          style={styles.input}
          value={this.state.password}
          onChangeText={(password) => this.setState({ password })}
        />
        <VButton onPress={this.login}>Login</VButton>
      </View>
    );
  }
}

export default LoginForm;
