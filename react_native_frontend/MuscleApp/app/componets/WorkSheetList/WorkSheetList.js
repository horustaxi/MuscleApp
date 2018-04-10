import React from 'react';
import { View, Text } from 'react-native';
import { connect } from 'react-redux';

class WorkSheetList extends React.PureComponent {
  render() {
    return (
      <View>
        <Text> textInComponent </Text>
      </View>
    );
  }
}

const mapStateToProps = state => {
  console.log(`state: ${JSON.stringify(state)}`);
  return { exercises: state.exercises };
};

export default connect(mapStateToProps)(WorkSheetList);
