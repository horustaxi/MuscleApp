import axios from 'axios';
import { Constants } from '../config/constants';

export const fetchExercises = () => {
  // axios.get(`${apiUrl}exercises`,
  //   {
  //     headers: {
  //       // TODO get token from storage
  //       Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aW5pY2l1cy52YXMudGlAZ21haWwuY29tIiwiZXhwIjoxNTI0MTkyODA3fQ.S_FEWLWLLF6O5ndc5BcS5_tTwvCm0l1z5e0j6TskTvhwu2ukhYIwiN4FCmQSkUKAMboGZbpIR6VBaM6HqWTFFQ'
  //     }
  //   })
  //   .then(response => (console.log(response.data)))
  //   .catch(response => {
  //     console.error(`erro: ${response}`);
  //   });

  const request = axios.get(`${Constants.apiUrl}exercises`,
  {
    headers: {
      // TODO get token from storage
      Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aW5pY2l1cy52YXMudGlAZ21haWwuY29tIiwiZXhwIjoxNTI0MTkyODA3fQ.S_FEWLWLLF6O5ndc5BcS5_tTwvCm0l1z5e0j6TskTvhwu2ukhYIwiN4FCmQSkUKAMboGZbpIR6VBaM6HqWTFFQ'
    }
  });

  return {
    type: Constants.actionTypes.FETCH_EXERCISES,
    payload: request
  };
};
