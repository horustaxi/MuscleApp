import React from 'react';
import { TextInput, View, Text } from 'react-native';
import styles from './styles';

const Input = ({ label, value, onChangeText, placeholder, secureTextEntry }) => {
  const { inputStyle, inputContainerStyle, inputLabelStyle } = styles;

  return (
    <View style={inputContainerStyle}>
      <Text style={inputLabelStyle}>{label}</Text>
      <TextInput
        style={inputStyle}
        placeholder={placeholder}
        value={value}
        onChangeText={onChangeText}
        underlineColorAndroid='transparent'
        autoCorrect={false}
        secureTextEntry={secureTextEntry}
      />
    </View>
  );
};

export { Input };
