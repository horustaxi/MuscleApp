import React from 'react';
import { Text, View, Image } from 'react-native';
import styles from './styles';
import Card from '../Card/index';
import CardSection from '../Card/CardSection';

class ExerciseDetail extends React.PureComponent {
  render() {
    const { name, mainMuscle } = this.props.exercise;
    return (
      <Card>
        <CardSection>
          <View>
            <Image
              source={{ uri: 'https://wger.de/media/exercise-images/60/Hyperextensions-2.png' }}
              style={{ width: 80, height: 80 }}
            />
          </View>
          <View style={styles.headerContentStyle}>
            <Text style={styles.textStyle}> {name} </Text>
            <Text style={styles.textStyle}> {mainMuscle} </Text>
          </View>
        </CardSection>
      </Card>
    );
  }
}

export default ExerciseDetail;
