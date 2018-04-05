import React from 'react';
import { Text, TouchableOpacity } from 'react-native';

const ViewMoreButton = ({ onPress }) => (
    <TouchableOpacity onPress={onPress}>
      <Text>View more...</Text>
    </TouchableOpacity>
  );

export default ViewMoreButton;
