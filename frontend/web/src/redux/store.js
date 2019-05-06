import {
  createStore, combineReducers, applyMiddleware, compose,
} from 'redux';
import { createBrowserHistory } from 'history';
import thunk from 'redux-thunk';
import { reducer as formReducer } from 'redux-form';
import createSagaMiddleware from 'redux-saga';
import { connectRouter, routerMiddleware } from 'connected-react-router';
import reducers from './reducers';
import rootSaga from './sagas';

const history = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();
const middlewares = [thunk, sagaMiddleware, routerMiddleware(history)];
const combinedReducers = combineReducers({
  ...reducers,
  router: connectRouter(history),
  form: formReducer,
});

const store = createStore(combinedReducers, compose(applyMiddleware(...middlewares)));
sagaMiddleware.run(rootSaga);
export { store, history };
