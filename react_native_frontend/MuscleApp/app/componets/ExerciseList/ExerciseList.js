'use strict';

import React from 'react';
import { ScrollView } from 'react-native';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { fetchExercises } from '../../actions';
import ExerciseListItem from './ExerciseListItem';
import { Spinner } from '../Common';

class ExerciseList extends React.PureComponent {

  static navigationOptions = {
    title: 'Exercises',
  };

  constructor(props) {
    super(props);
    this.state = {
      modalVisible: false,
    };
  }

  componentDidMount() {
    this.props.fetchExercises();
  }

  setModalVisible(visible) {
    this.setState({ modalVisible: visible });
  }

  renderExercises() {
    return this.props.exercises.map(exercise => 
      <ExerciseListItem key={exercise.id} exercise={exercise} />
    );
  }

  render() {
    if (!this.props.exercises || !this.props.exercises[0]) {
      return (
        <Spinner />
      );
    }

    return (
      <ScrollView style={{ flex: 1, marginBottom: 10 }}>
        {this.renderExercises()}
      </ScrollView>
    );  
  }
}

const mapStateToProps = state => ({ exercises: state.exercises.all });

const mapDispatchToProps = (dispatch) => bindActionCreators({ fetchExercises }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(ExerciseList);
