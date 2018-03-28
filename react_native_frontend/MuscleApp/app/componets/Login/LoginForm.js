import React from 'react';
import { TextInput, View, Button } from 'react-native';
import axios from 'axios';
import styles from './styles';
import { Constants } from '../../config/constants';

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
      .then(response => console.log(response.headers.authorization))
      .catch(response => console.error(response));
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
        <Button
          onPress={this.login}
          title="Login"
          color="#841584"
          accessibilityLabel="Learn more about this purple button"
        />
      </View>
    );
  }
}

export default LoginForm;
