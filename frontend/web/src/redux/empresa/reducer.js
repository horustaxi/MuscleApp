import actions from './actions';

const initState = {
  all: [],
  empresa: null,
  loading: false,
  resposta: '',
  tipoResposta: ''
};

export default function empresasReducer(state = initState, action) {
  switch (action.type) {
    case actions.FETCHED_ALL:
      return { ...state, all: action.payload }
    case actions.FETCHED_ONE:
      return { ...state, empresa: action.payload }
    case actions.SET_LOADING:
      return { ...state, loading: action.payload };
    case actions.SAVE_SUCCESS:
      return { ...state, resposta: action.payload, tipoResposta: 'success' };
    case actions.REQUEST_ERROR:
      return { ...state, resposta: action.payload, tipoResposta: 'error' };
    case actions.CLEAR_RESPOSTA:
      return { ...state, resposta: '', tipoResposta: '' };
    default:
      return state;
  }
}