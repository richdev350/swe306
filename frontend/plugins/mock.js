const Mock = require('mockjs');
const isMocking = true;
if (isMocking) {
  Mock.mock(/api\/auth\/signin/, 'post', data => {
      console.log('signin', data);
      return {
        message: 'haha',
        user: {
          username: 'admin',
          fullname: 'James Bond',
          role: 'admin'
        },
        token: '123456'
      };
    }
  );

  Mock.mock(/api\/auth\/myInfo/, 'get', data => {
      console.log('my info');
      console.log(data);
      return {
        user: {
          username: 'admin',
          fullname: 'James Bond',
          role: 'admin'
        }
      };
    }
  );

  Mock.mock(/api\/auth\/signup/, 'post', data => {
      console.log('received:');
      console.log(data);
      return {
        success: true
      };
    }
  );


  Mock.mock(/api\/test/, 'get', data => {
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

}
