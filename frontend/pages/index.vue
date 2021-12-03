<template>
  <div>
    <el-container class='main-layout'>
      <el-main>
        Main
        <el-button type='primary' @click='sendReq'>
          Send Req
        </el-button>
        {{ ip }}
      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'index',
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
      this.ip = ip;
    }
  }
};
</script>
