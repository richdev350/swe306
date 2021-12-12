const Mock = require('mockjs');

Mock.mock(/api\/login/, 'get', data => {
    console.log(data);
    return {
      'data': {
        auth: true
      }
    };
  }
);

Mock.mock(/\/info/, 'post', data => {
    console.log(data);
    return {
      'list|1-10': [{
        'id|+1': 1,
        name: '@cname'
      }]
    };
  }
);
