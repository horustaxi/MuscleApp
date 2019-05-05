export const endpoint = 'empresas/';
const actions = {
  SAVE_REQUEST: 'SAVE_REQUEST_EMPRESA',
  SAVE_SUCCESS: 'SAVE_SUCCESS',
  FETCH_ALL: 'FETCH_ALL_EMPRESA',
  FETCHED_ALL: 'FETCHED_ALL_EMPRESA',
  FETCH_ONE: 'FETCH_ONE_EMPRESA',
  FETCHED_ONE: 'FETCHED_ONE_EMPRESA',
  REQUEST_ERROR: 'REQUEST_ERROR',
  CLEAR_RESPOSTA: 'CLEAR_RESPOSTA',
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