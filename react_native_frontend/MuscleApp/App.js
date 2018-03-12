'use strict';

import { StackNavigator } from 'react-navigation';
import ExerciseList from './app/componets/ExerciseList/ExerciseList';
import Login from './app/componets/Login/Login';
import EStyleSheet from 'react-native-extended-stylesheet';

EStyleSheet.build({ // always call EStyleSheet.build() even if you don't use global variables!
  $ptextColor: '#ffffff',
  $primary: "#424242",
  $plight: "#6d6d6d",
  $pdark: "#1b1b1b"
});

const App = StackNavigator({
  Home: { screen: Login },
});
export default App;