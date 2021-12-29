import Element from 'element-ui';
import config from '~/service/config';

export default function({ $axios }, inject) {
  // Create a custom axios instance
  const api = $axios.create(config);
  api.defaults.withCredentials = true;
  // request handler
  let loadingInstance;
  api.onRequest((config) => {
    loadingInstance = Element.Loading.service({
      lock: true,
      text: 'Loading',
      spinner: 'el-icon-loading',
      background: 'rgba(0, 0, 0, 0.7)'
    });
    console.log('api is making request to ' + config.url);
  });

  api.onResponse((response) => {
    loadingInstance.close();
  });

  // error interceptor
  api.onError((error) => {
    loadingInstance.close();
    console.log(error);
    const code = parseInt(error.response && error.response.status);
    Element.Message.error(
      `Error Message: ${ error.response.data.message }, Error Code:${ code }`
    );
    return Promise.resolve(false);
    // return Promise.reject(error);
  });

  // Inject to context as $api
  inject('api', api);
}
