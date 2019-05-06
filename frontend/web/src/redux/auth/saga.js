import {
  all, takeEvery, put, fork, call,
} from 'redux-saga/effects';
import { push } from 'connected-react-router';
import axios from 'axios';
import { getToken, clearToken } from '../../helpers/utility';
import actions from './actions';
import settings from '../../settings';

const fakeApiCall = false; // auth0 or express JWT
const { apiUrl } = settings;

export function* loginAsync({ payload: { login, password } }) {
  if (fakeApiCall) {
    yield put({
      type: actions.LOGIN_SUCCESS,
      token: 'secret token',
      profile: 'Profile',
    });
  } else {
    try {
      // const response = yield call(axios.post, `${apiUrl}login`,  {
      //   username: login,
      //   password: password
      // });
      yield put({
        type: actions.LOGIN_SUCCESS,
        token: 'response.headers.authorization',
        profile: 'Profile',
      });
    } catch (error) {
      console.error('login error response', error);
      if (error.response.status === 403) {
        yield put({ type: actions.LOGIN_ERROR, payload: 'Usuário ou Senha Inválidos' });
      } else {
        console.error('login error response', error.response);
      }
    }
  }
}

export function* loginRequest() {
  yield takeEvery('LOGIN_REQUEST', loginAsync);
}

export function* loginSuccess() {
  yield takeEvery(actions.LOGIN_SUCCESS, function* (payload) {
    yield localStorage.setItem('id_token', payload.token);
  });
}

export function* logout() {
  yield takeEvery(actions.LOGOUT, function* () {
    clearToken();
    yield put(push('/'));
  });
}

export function* checkAuthorization() {
  yield takeEvery(actions.CHECK_AUTHORIZATION, function* () {
    const token = getToken().get('idToken');
    if (token) {
      yield put({
        type: actions.LOGIN_SUCCESS,
        token,
        profile: 'Profile',
      });
    }
  });
}

export default function* rootSaga() {
  yield all([fork(checkAuthorization), fork(loginRequest), fork(loginSuccess), fork(logout)]);
}
