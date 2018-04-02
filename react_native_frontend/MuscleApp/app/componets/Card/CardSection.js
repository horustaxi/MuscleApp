import React from 'react';
import { View, Text } from 'react-native';
import styles from './styles';

const CardSection = (props) => (
      <View>
        <Text style={styles.cardSectionStyle}>
          {props.children}
        </Text>
      </View>
    );

export default CardSection;
