import http from 'http';
import https from 'https';

export default {
  headers: {
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
};
