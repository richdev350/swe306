import Element from 'element-ui';
import config from '~/service/config';

export default function({ $axios }, inject) {
  // Create a custom axios instance
  const api = $axios.create(config);
  // request handler
  api.onRequest(config => {
    // Element.Loading.service({
    //   lock: true,
    //   text: 'Loading',
    //   background: 'rgba(0, 0, 0, 0.7)'
    // });
    console.log('requesting...');
  });

  // error interceptor
  api.onError(error => {
    console.log(error);
    const code = parseInt(error.response && error.response.status);
    Element.Message.error(`Error Message: ${ error.response.data.message }, Error Code:${ code }`);
    return Promise.resolve(false);
    // return Promise.reject(error);
  });

  // Inject to context as $api
  inject('api', api);
}
