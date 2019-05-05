export const endpoint = 'filiais/';

const actions = {
  SAVE_REQUEST: 'SAVE_REQUEST_FILIAL',
  SAVE_SUCCESS: 'SAVE_SUCCESS',
  FETCH_ALL: 'FETCH_ALL_FILIAL',
  FETCHED_ALL: 'FETCHED_ALL_FILIAL',
  FETCH_ONE: 'FETCH_ONE_FILIAL',
  FETCHED_ONE: 'FETCHED_ONE_FILIAL',
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
    // settando empresa como um objeto com id, já que a view enxerga como empresa sendo o próprio id
    entity.empresa = { id: entity.empresa };
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