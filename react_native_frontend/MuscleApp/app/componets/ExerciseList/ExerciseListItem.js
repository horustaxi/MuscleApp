import React from 'react';
import { Text, View, Image, TouchableHighlight, TouchableOpacity } from 'react-native';
import Modal from 'react-native-modal';
import styles from './styles';
import Card from '../Card/index';
import CardSection from '../Card/CardSection';
import { capitalizeFirst, capitalizeAll, arrayToString } from '../../config/Util';
import ViewMoreButton from '../ViewMoreButton/index';
import ExerciseDetails from './ExerciseDetails';

class ExerciseListItem extends React.PureComponent {
  state = {
    modalVisible: false,
  };

  setModalVisible(visible) {
    this.setState({ modalVisible: visible });
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
      <View>
        <Modal
          isVisible={this.state.modalVisible}
          onBackdropPress={() => {
            this.setModalVisible(!this.state.modalVisible);
          }}
        >
          <View style={styles.modalStyle}>
            <ExerciseDetails value={this.props.exercise}>
              <TouchableOpacity
                onPress={() => {
                  this.setModalVisible(!this.state.modalVisible);
                }}
              >
                <Text style={{ color: 'grey' }}>Close</Text>
              </TouchableOpacity>
            </ExerciseDetails>
          </View>
        </Modal>

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
                  <ViewMoreButton onPress={() => this.setModalVisible(true)} />
                </View>
                <Text style={textStyle}> {capitalizeAll(arrayToString(mainMuscles))} </Text>
              </View>
            </CardSection>
          </Card>
        </TouchableHighlight>
      </View>
    );
  }
}

export default ExerciseListItem;
