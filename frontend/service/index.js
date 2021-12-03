import axios from '@nuxtjs/axios';
import config from './config.js';

// if (process.server) {
//   config.baseURL = `http://${ process.env.HOST || 'localhost' }:${ process.env.PORT || 3000 }`;
// }

config.baseURL = `http://localhost:8080`;


const service = axios.create(config);

service.interceptors.request.use(
  config => {
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

export default service;
