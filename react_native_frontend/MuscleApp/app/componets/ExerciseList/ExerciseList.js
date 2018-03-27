'use strict';

import React from 'react';
import { Image, View, TouchableHighlight, FlatList, Text } from 'react-native';
import styles from './styles';

class ExerciseList extends React.PureComponent {
    static navigationOptions = {
        title: 'Exercises',
    };
    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.textStyle}>Testando</Text>
            </View>
        ); 
    }
}

export default ExerciseList;
