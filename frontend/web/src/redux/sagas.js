import { all } from 'redux-saga/effects';
import authSagas from './auth/saga';
import empresasSagas from './empresa/saga';
import filialSagas from './filial/saga';
import cargoSagas from './cargo/saga';
import usuarioSagas from './usuario/saga';
import fazendaSagas from './fazenda/saga';
import permissaoSagas from './permissao/saga';

export default function* rootSaga(getState) {
  yield all([
    authSagas(),
    empresasSagas(),
    filialSagas(),
    cargoSagas(),
    usuarioSagas(),
    fazendaSagas(),
    permissaoSagas(),
  ]);
}
