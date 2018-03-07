'use strict';

import { StackNavigator } from 'react-navigation';
import ExerciseList from './app/componets/ExerciseList/ExerciseList';

const App = StackNavigator({
  Home: { screen: ExerciseList },
});
export default App;