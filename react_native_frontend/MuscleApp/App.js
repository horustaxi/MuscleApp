'use strict';

import { StackNavigator } from 'react-navigation';
import EStyleSheet from 'react-native-extended-stylesheet';
import ExerciseList from './app/componets/ExerciseList/ExerciseList';
import Login from './app/componets/Login/Login';

EStyleSheet.build({ // always call EStyleSheet.build() even if you don't use global variables!
  $ptextColor: '#ffffff',
  $primary: '#424242',
  $plight: '#6d6d6d',
  $pdark: '#1b1b1b'
});

const App = StackNavigator({
  Login: { screen: Login },
  Exercises: { screen: ExerciseList },
},
{
  initialRouteName: 'Login',
});

export default App;
