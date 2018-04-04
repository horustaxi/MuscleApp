import React from 'react';
import { Text, TouchableOpacity } from 'react-native';
import styles from './styles';

const VButton = ({ children, onPress }) => (
    <TouchableOpacity style={styles.buttonStyle} onPress={onPress}>
      <Text style={styles.textStyle}>
        {children}
      </Text>
    </TouchableOpacity>
  );

export default VButton;
