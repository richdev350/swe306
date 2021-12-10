import http from 'http';
import https from 'https';
import Element from 'element-ui';

export default function({ $axios }, inject) {
  // Create a custom axios instance
  const config = {
    // baseURL: 'http://localhost:8080/SWE306_FinalProejct_Backend_war_exploded',
    proxy: true,
    baseURL: '/api',
    headers: {
      common: {
        Accept: 'text/plain, */*'
      },
      'X-Requested-With': 'XMLHttpRequest',
      'X-Agent': 'swe301/Web',
    },
    timeout: 5000,
    // cors with credentials
    withCredentials: true,
    // responseType: 'json',
    // xsrf
    // this is useless
    xsrfCookieName: 'XSRF-TOKEN',
    xsrfHeaderName: 'X-XSRF-TOKEN',
    // nodejs
    httpAgent: new http.Agent({
      keepAlive: true
    }),
    httpsAgent: new https.Agent({
      keepAlive: true
    }),
    retry: {
      retries: 3
    }
  };

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
