'use strict';

import React from 'react';
import { ScrollView } from 'react-native';
import axios from 'axios';
// import styles from './styles';
import { Constants } from '../../config/constants';
import ExerciseDetail from './ExerciseDetail';

class ExerciseList extends React.PureComponent {

    static navigationOptions = {
        title: 'Exercises',
    };

    constructor(props) {
        super(props);
        this.state = { exercises: [] };
    }

    componentWillMount() {
        axios.get(`${Constants.apiUrl}exercises`,
        {
            headers: {
                Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aW5pY2l1cy52YXMudGlAZ21haWwuY29tIiwiZXhwIjoxNTIzMTM4OTg3fQ.wWB5s95OiWOeajFYOV5h1qcAil5FiATcQyPJpKPwq2ZwoqGRo8n86kcQjk09grwiz0Jof1PK8LZBr7t4C6-zVw'
            }
        })
        .then(response => {
            //console.log(response.data);
            this.setState({ exercises: response.data });
        })
        .catch(response => {
            console.error(`erro: ${response}`);
        });
    }

    renderExercises() {
        return this.state.exercises.map(exercise => 
            <ExerciseDetail key={exercise.id} exercise={exercise} />
        );
    }

    render() {
        return (
            <ScrollView style={{ flex: 1, marginBottom: 10 }}>
                {this.renderExercises()}
            </ScrollView>
        ); 
    }
}

export default ExerciseList;
