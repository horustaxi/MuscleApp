import React from 'react';
import { View, Text } from 'react-native';
import { capitalizeFirst, capitalizeAll, arrayToString } from '../../config/Util';

class ExerciseDetails extends React.PureComponent {

  static navigationOptions = {
    title: 'Exercises',
  };

  render(props) {
    const { name, mainMuscles, secondaryMuscles, description } = this.props.value;

    return (
      <View>
        <Text>Name: {capitalizeFirst(name)} </Text>
        <Text>Main Muscles: {capitalizeAll(arrayToString(mainMuscles))} </Text>
        <Text>Secondary Muscles: {capitalizeAll(arrayToString(secondaryMuscles))} </Text>
        <Text>Description: {capitalizeFirst(description)} </Text>
        {this.props.children}
      </View>
    );
  }
}

export default ExerciseDetails;
