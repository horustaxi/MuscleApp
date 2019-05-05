import { all, takeEvery, takeLatest, put, fork, call } from 'redux-saga/effects';
import axios from 'axios';
import actions, { endpoint } from './actions';
import settings from '../../settings';
import { getToken } from '../../helpers/utility';

const { apiUrl } = settings;
const header = {
  headers: {
    Authorization : getToken().get('idToken')
  }
};


export function* saveAsync({ payload: entity }) {
  let responseSuccess = entity.id ? 'Registro alterado com sucesso' : 'Registro salvo com sucesso';
  yield put({ type: actions.SET_LOADING, payload: true });
  try {
    if (entity.id) {
      yield call(axios.put, apiUrl+endpoint+entity.id, entity, header);
    } else {
      yield call(axios.post, apiUrl+endpoint, entity, header);
    }
    yield put({ type: actions.SAVE_SUCCESS, payload: responseSuccess });
  } catch (error) {
    console.log('saveAsync',error);
    yield put({ type: actions.SET_LOADING, payload: false });
    if (!error.response) {
      yield put({ type: actions.REQUEST_ERROR, payload: error.message });
    } else if (error.response.status === 403) {
      console.log('post response', error.response);
      yield put({ type: actions.REQUEST_ERROR, payload: error.response.data.message });
    } else {
      yield put({ type: actions.REQUEST_ERROR, payload: error.response.data.message });
      console.error('post error response', error.response);
    }
  }
  yield put({ type: actions.SET_LOADING, payload: false });
}

export function* saveRequest() {
  yield takeEvery(actions.SAVE_REQUEST, saveAsync);
}

export function* fetchAllAsync() {
  console.log(header);
  yield put({ type: actions.SET_LOADING, payload: true });
  try {
    const response = yield call(axios.get, apiUrl+endpoint, header);
    yield put({ type: actions.FETCHED_ALL, payload: response.data });
  } catch (error) {
    if (!error.response) {
      yield put({ type: actions.REQUEST_ERROR, payload: error.message });
    } else {
      yield put({ type: actions.REQUEST_ERROR, payload: error.response.data.message });
      console.error('get all error response', error.response);
    }
  }
  yield put({ type: actions.SET_LOADING, payload: false });
}

export function* fetchAllRequest() {
  yield takeLatest(actions.FETCH_ALL, fetchAllAsync);
}

export function* fetchOneAsync({ payload: id }) {
  yield put({ type: actions.SET_LOADING, payload: true });
  try {
    const response = yield call(axios.get, apiUrl+endpoint+id, header);
    yield put({ type: actions.FETCHED_ONE, payload: response.data });
  } catch (error) {
    if (!error.response) {
      yield put({ type: actions.REQUEST_ERROR, payload: error.message });
    } else {
      yield put({ type: actions.REQUEST_ERROR, payload: error.response.data.message });
      console.error('get one error response', error.response);
    }
  }
  yield put({ type: actions.SET_LOADING, payload: false });
}

export function* fetchOneRequest() {
  yield takeLatest(actions.FETCH_ONE, fetchOneAsync);
}

export default function* rootSaga() {
  yield all([
    fork(saveRequest),
    fork(fetchAllRequest),
    fork(fetchOneRequest),
  ]);
}
