import React from 'react';
import { Text } from 'react-native';
import styles from './styles';
import Card from '../Card/index';
import CardSection from '../Card/CardSection';

class ExerciseDetail extends React.PureComponent {
  render(props) {
    return (
      <Card>
        <CardSection>
          <Text style={styles.textStyle}> {this.props.exercise.name} </Text>
        </CardSection>
        <CardSection>
          <Text style={styles.textStyle}> {this.props.exercise.description} </Text>
        </CardSection>
      </Card>
    );
  }
}

export default ExerciseDetail;
