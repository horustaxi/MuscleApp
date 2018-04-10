'use strict';

import React from 'react';
import { StackNavigator } from 'react-navigation';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import ReduxPromise from 'redux-promise';
import EStyleSheet from 'react-native-extended-stylesheet';
import ExerciseList from './app/componets/ExerciseList';
import WorkSheetList from './app/componets/WorkSheetList';
import LoginForm from './app/componets/Login';
import AppLoading from './app/componets/Login/AppLoading';
import SignUpForm from './app/componets/Login/SignUpForm';
import reducers from './app/reducers';

EStyleSheet.build({ // always call EStyleSheet.build() even if you don't use global variables!
  $ptextColor: '#424242',
  $primary: '#6d6d6d',
  $plight: '#ffffff',
  $pdark: '#1b1b1b'
});

// https://reactnavigation.org/docs/getting-started.html
const AuthStack = StackNavigator(
  { Login: LoginForm, 'Sign Up': SignUpForm },
  {
    headerMode: 'none'
  }
);

const AppStack = StackNavigator(
  {
    Exercises: ExerciseList,
    WorkSheets: WorkSheetList,
  },
  {
    headerMode: 'none'
  }
);

const SwitchNavigator = StackNavigator(
  {
    AppLoading,
    App: AppStack,
    Auth: AuthStack,
  },
  {
    initialRouteName: 'AppLoading',
  }
);

const createStoreWithMiddleware = applyMiddleware(ReduxPromise)(createStore);
const store = createStoreWithMiddleware(reducers);

class App extends React.PureComponent {
  render() {
    return (
      <Provider store={store}>
        <SwitchNavigator />
      </Provider>
    );
  }
}

export default App;
