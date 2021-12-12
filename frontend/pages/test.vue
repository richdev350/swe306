<template>
  <div>
    <el-container class='main-layout'>
      <el-main>
        Main
        <el-button type='primary' @click='cook'>
          Set
        </el-button>
        <el-button type='primary' @click='getCook'>
          Get
        </el-button>
        <el-button type='primary' @click='apiTest'>
          API
        </el-button>
        <el-button type='primary' @click='sendReq'>
          send
        </el-button>

        {{ ip }}
        <br>
        {{ something }}
        <el-button @click='mockTest'>
          mock
        </el-button>
      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'Test',
  data() {
    return {
      ip: ''
    };
  },

  methods: {
    async sendReq() {
      // const ipAddr = 'http://icanhazip.com';
      const testCon = 'http://localhost:8080/SWE306_FinalProejct_Backend_war_exploded/api/test/login';
      const ip = await this.$axios.$get(testCon);
      // this.ip = ip;
      console.log(ip);
    },
    cook() {
      this.$cookies.set('token', 'John Doe', {
        path: '/',
        maxAge: 60 * 60 * 24 * 7
      });
    },
    getCook() {
      this.ip = this.$cookies.get('token');
    },
    apiTest() {
      this.$api.$get('/api/test/login').then(res => {
        console.log(res);
      });
    },
    mockTest() {
      this.$api.$get('/login')
        .then((res) => {
          console.log(res);
        });
    }

  }
};
</script>
