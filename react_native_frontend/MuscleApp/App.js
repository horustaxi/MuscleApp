'use strict';

import { StackNavigator } from 'react-navigation';
import EStyleSheet from 'react-native-extended-stylesheet';
import ExerciseList from './app/componets/ExerciseList';
import LoginForm from './app/componets/Login';

EStyleSheet.build({ // always call EStyleSheet.build() even if you don't use global variables!
  $ptextColor: '#424242',
  $primary: '#6d6d6d',
  $plight: '#ffffff',
  $pdark: '#1b1b1b'
});

// https://reactnavigation.org/docs/getting-started.html
const App = StackNavigator(
  {
    Login: { screen: LoginForm },
    Exercises: { screen: ExerciseList },
  },
  {
    initialRouteName: 'Login',
  }
);

export default App;
