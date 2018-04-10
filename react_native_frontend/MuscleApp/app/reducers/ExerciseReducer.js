'use strict';
import { actionTypes } from '../config/constants';

export default (state = {}, action) => {
  console.log(action);
  switch (action.type) {
    case actionTypes.FETCH_EXERCISES:
      return { ...state, exercises: action.payload.data };
    default:
      return state;
  }
};
