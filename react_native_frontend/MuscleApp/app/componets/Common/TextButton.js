import React from 'react';
import { Text, TouchableOpacity } from 'react-native';

const TextButton = ({ onPress, text, textStyle }) => (
    <TouchableOpacity onPress={onPress}>
      <Text style={textStyle}>{text}</Text>
    </TouchableOpacity>
  );

export { TextButton };
