'use strict';

import React from 'react';
import { ScrollView, Text } from 'react-native';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import axios from 'axios';
import { fetchExercises } from '../../actions';
import { Constants } from '../../config/constants';
import ExerciseListItem from './ExerciseListItem';

class ExerciseList extends React.PureComponent {

  static navigationOptions = {
    title: 'Exercises',
  };

  constructor(props) {
    super(props);
    this.state = {
      exercises: [],
      modalVisible: false,
      // TODO: use a loading spinner while exercises arent fetched yet
      loading: true
    };
  }

  componentDidMount() {
    // axios.get(`${Constants.apiUrl}exercises`,
    // {
    //   headers: {
    //     Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aW5pY2l1cy52YXMudGlAZ21haWwuY29tIiwiZXhwIjoxNTIzMTM4OTg3fQ.wWB5s95OiWOeajFYOV5h1qcAil5FiATcQyPJpKPwq2ZwoqGRo8n86kcQjk09grwiz0Jof1PK8LZBr7t4C6-zVw'
    //   }
    // })
    // .then(response => {
    //   //console.log(response.data);
    //   this.setState({ exercises: response.data, loading: false });
    // })
    // .catch(response => {
    //   console.error(`erro: ${response}`);
    // });

    this.props.fetchExercises();
  }

  setModalVisible(visible) {
    this.setState({ modalVisible: visible });
  }

  renderExercises() {
    if (!this.props.exercises) {
      return (
        <Text>Loading...</Text>
      );
    }

    return this.state.exercises.map(exercise => 
      <ExerciseListItem key={exercise.id} exercise={exercise} />
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

const mapStateToProps = state => {
  //console.log(`state: ${JSON.stringify(state)}`);
  return { exercises: state.exercises };
};

const mapDispatchToProps = (dispatch) => bindActionCreators({ fetchExercises }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(ExerciseList);
