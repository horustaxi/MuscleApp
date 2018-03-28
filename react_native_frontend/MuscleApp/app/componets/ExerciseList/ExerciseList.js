'use strict';

import React from 'react';
import { Image, View, TouchableHighlight, FlatList, Text } from 'react-native';
import axios from 'axios';
import styles from './styles';
import { Constants } from '../../config/constants';

class ExerciseList extends React.PureComponent {

    static navigationOptions = {
        title: 'Exercises',
    };

    constructor(props) {
        super(props);
        state = { exercises: [] };
    }

    componentWillMount() {
        axios.get(`${Constants.apiUrl}exercise`,
        {
            headers: {
                Authorization: 'Bearer ' + ''
            }
        })
        .then(response => console.log(response));
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.textStyle}>Testando</Text>
            </View>
        ); 
    }
}

export default ExerciseList;
