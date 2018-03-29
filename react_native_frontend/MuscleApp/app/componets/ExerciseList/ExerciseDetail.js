import React from 'react';
import { Text } from 'react-native';
import styles from './styles';
import Card from '../Card/index';

class ExerciseDetail extends React.PureComponent {
  render(props) {
    return (
      <Card>
        <Text style={styles.textStyle}> {this.props.exercise.name} </Text>
      </Card>
    );
  }
}

export default ExerciseDetail;
