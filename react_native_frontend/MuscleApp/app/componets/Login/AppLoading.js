import React from 'react';
import {
  ActivityIndicator,
  AsyncStorage,
  StatusBar,
  View,
} from 'react-native';

class AppLoading extends React.Component {
  
  constructor(props) {
    super(props);
    this.verifyTokenStored();
  }

  // Fetch the token from storage then navigate to our appropriate place
  verifyTokenStored = async () => {
    const userToken = await AsyncStorage.getItem('@MuscleApp:token');

    // This will switch to the App screen or Auth screen and this loading
    // screen will be unmounted and thrown away.
    this.props.navigation.replace(userToken ? 'App' : 'Auth');
  };

  // Render any loading content that you like here
  render() {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', }}>
        <ActivityIndicator size="large" />
        <StatusBar barStyle="default" />
      </View>
    );
  }
}

export default AppLoading;
