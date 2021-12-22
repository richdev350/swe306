import http from 'http';
import https from 'https';

// axios custom config
// used in axios plugin
export default {
  // baseURL: 'http://localhost:8080/SWE306_FinalProejct_Backend_war_exploded',
  proxy: true,
  baseURL: '/api',
  headers: {
    common: {
      Accept: 'text/plain, */*'
    },
    'X-Requested-With': 'XMLHttpRequest',
    'X-Agent': 'swe301/Web'
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
