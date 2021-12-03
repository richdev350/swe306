import http from 'http';
import https from 'https';

export default function({ $axios }, inject) {
  // Create a custom axios instance
  const api = $axios.create({
    headers: {
      common: {
        Accept: 'text/plain, */*'
      },
      'X-Requested-With': 'XMLHttpRequest',
      'X-Agent': 'swe301/Web'
    },
    timeout: 10000,
    // cors with credentials
    withCredentials: true,
    responseType: 'json',
    // xsrf
    xsrfCookieName: 'XSRF-TOKEN',
    xsrfHeaderName: 'X-XSRF-TOKEN',
    // nodejs
    httpAgent: new http.Agent({
      keepAlive: true
    }),
    httpsAgent: new https.Agent({
      keepAlive: true
    })

  });

  // Set baseURL to something different
  api.setBaseURL('https://localhost:8080');

  // error handler
  api.onError(error => {
    console.log(error);
    return Promise.resolve(false);
    // return Promise.reject(error);
  });

  // Inject to context as $api
  inject('api', api);
}
