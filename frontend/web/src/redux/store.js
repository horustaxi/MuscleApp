import {
  createStore, combineReducers, applyMiddleware, compose,
} from 'redux';
import { createBrowserHistory } from 'history';
import thunk from 'redux-thunk';
import { reducer as formReducer } from 'redux-form';
import createSagaMiddleware from 'redux-saga';
import reducers from './reducers';
import rootSaga from './sagas';

const history = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();
const middlewares = [thunk, sagaMiddleware];

const store = createStore(
  combineReducers({
    ...reducers,
    form: formReducer,
  }),
  compose(applyMiddleware(...middlewares)),
);
sagaMiddleware.run(rootSaga);
export { store, history };
