import React from 'react';
import { Text, TouchableOpacity } from 'react-native';

const ViewMoreButton = () => (
    <TouchableOpacity onPress={() => alert('test')}>
      <Text>View more...</Text>
    </TouchableOpacity>
  );

export default ViewMoreButton;
