export const endpoint = 'fazendas/';

const actions = {
  SAVE_REQUEST: 'SAVE_REQUEST_FAZENDA',
  SAVE_SUCCESS: 'SAVE_SUCCESS_FAZENDA',
  FETCH_ALL: 'FETCH_ALL_FAZENDA',
  FETCHED_ALL: 'FETCHED_ALL_FAZENDA',
  FETCH_ONE: 'FETCH_ONE_FAZENDA',
  FETCHED_ONE: 'FETCHED_ONE_FAZENDA',
  REQUEST_ERROR: 'REQUEST_ERROR_FAZENDA',
  CLEAR_RESPOSTA: 'CLEAR_RESPOSTA_FAZENDA',
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