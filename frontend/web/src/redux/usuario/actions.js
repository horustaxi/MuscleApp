export const endpoint = 'users/';

const actions = {
  SAVE_REQUEST: 'SAVE_REQUEST_USUARIO',
  SAVE_SUCCESS: 'SAVE_SUCCESS_USUARIO',
  FETCH_ALL: 'FETCH_ALL_USUARIO',
  FETCHED_ALL: 'FETCHED_ALL_USUARIO',
  FETCH_ONE: 'FETCH_ONE_USUARIO',
  FETCHED_ONE: 'FETCHED_ONE_USUARIO',
  REQUEST_ERROR: 'REQUEST_ERROR_USUARIO',
  CLEAR_RESPOSTA: 'CLEAR_RESPOSTA_USUARIO',
  SET_LOADING: 'SET_LOADING',
  fetchAll: () => ({
    type: actions.FETCH_ALL,
  }),
  fetchOne: (id) => ({
    type: actions.FETCH_ONE,
    payload: id
  }),
  save: (entity) => {
    return {
      type: actions.SAVE_REQUEST,
      payload: entity
    }
  },
  clearResposta: () => {
    return {
      type: actions.CLEAR_RESPOSTA
    }
  },
};


export default actions;