import React from 'react';
import { Text, View, Image } from 'react-native';
import styles from './styles';
import Card from '../Card/index';
import CardSection from '../Card/CardSection';
import { capitalizeFirst, capitalizeAll } from '../../config/Util';

class ExerciseDetail extends React.PureComponent {
  render() {
    const { name, mainMuscle } = this.props.exercise;
    const {
      imageContainerStyle,
      imageStyle,
      headerContentStyle,
      textStyle,
    } = styles;
    return (
      <Card>
        <CardSection>
          <View style={imageContainerStyle}>
            <Image
              source={{ uri: 'https://wger.de/media/exercise-images/60/Hyperextensions-2.png' }}
              style={imageStyle}
            />
          </View>
          <View style={headerContentStyle}>
            <Text style={textStyle}> {capitalizeFirst(name)} </Text>
            <Text style={textStyle}> {capitalizeAll(mainMuscle)} </Text>
          </View>
        </CardSection>
      </Card>
    );
  }
}

export default ExerciseDetail;
