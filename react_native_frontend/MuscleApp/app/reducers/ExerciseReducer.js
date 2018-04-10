'use strict';
import { Constants } from '../config/constants';

const INITIAL_STATE = {
  all: []
};

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case Constants.actionTypes.FETCH_EXERCISES:
      return { ...state, all: action.payload.data };
    default:
      return state;
  }
};
