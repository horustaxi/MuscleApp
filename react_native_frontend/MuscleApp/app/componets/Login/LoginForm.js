import React from 'react';
import { TextInput, View } from 'react-native';
import styles from './styles';

export class LoginForm extends React.PureComponent {
  render() {
    return (
      <View style={styles.container}>
        <TextInput
          placeholder="email"
          placeholderTextColor="grey"
          style={styles.input}
        />
        <TextInput
          placeholder="password"
          placeholderTextColor="grey"
          style={styles.input}
        />
      </View>
    );
  }
}

export default LoginForm;
