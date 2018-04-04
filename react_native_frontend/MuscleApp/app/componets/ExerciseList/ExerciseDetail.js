import React from 'react';
import { Text, View, Image, TouchableHighlight } from 'react-native';
import styles from './styles';
import Card from '../Card/index';
import CardSection from '../Card/CardSection';
import { capitalizeFirst, capitalizeAll } from '../../config/Util';
import ViewMoreButton from '../ViewMoreButton/index';

class ExerciseDetail extends React.PureComponent {
  getMuscles(mainMuscles) {
    return mainMuscles.map(muscle => muscle.name).join(', ');
  }

  render() {
    const { name, mainMuscles } = this.props.exercise;
    const {
      imageContainerStyle,
      imageStyle,
      headerContentStyle,
      textStyle,
    } = styles;
    return (

      <TouchableHighlight onPress={() => alert('touched')}>
      <Card>
        <CardSection>
          <View style={imageContainerStyle}>
            <Image
              source={{ uri: 'https://wger.de/media/exercise-images/60/Hyperextensions-2.png' }}
              style={imageStyle}
            />
          </View>
          <View style={headerContentStyle}>
            <View style={{ flex: 1, flexDirection: 'row', justifyContent: 'space-between' }}>
              <Text style={[textStyle, { fontWeight: 'bold' }]}> {capitalizeFirst(name)} </Text>
              <ViewMoreButton />
            </View>
            <Text style={textStyle}> {capitalizeAll(this.getMuscles(mainMuscles))} </Text>
          </View>
        </CardSection>
      </Card>
      </TouchableHighlight>
    );
  }
}

export default ExerciseDetail;
