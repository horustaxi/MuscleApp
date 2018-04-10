import { combineReducers } from 'redux';
import WorkSheetReducer from './WorkSheetReducer';
import ExerciseReducer from './ExerciseReducer';

export default combineReducers({
  workSheets: WorkSheetReducer,
  exercises: ExerciseReducer
});
