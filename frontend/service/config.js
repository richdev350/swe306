import http from 'http';
import https from 'https';

// axios config for $api
export default {
  // baseURL: 'http://111.229.100.125/api',
  baseURL: 'http://localhost:8080/api',
  // no need to proxy since backend has allowed CORS
  proxy: false,
  // baseURL: '/api',
  headers: {
    common: {
      Accept: 'text/plain, */*'
    },
    'X-Requested-With': 'XMLHttpRequest',
    'X-Agent': 'swe306/Web',
  },
  timeout: 5000,
  // cors proxy with credentials
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
