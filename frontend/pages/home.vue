<template>
  <div>
    <CustomPageTitle>Home</CustomPageTitle>
    <el-button>
      <NuxtLink to='test'>Test</NuxtLink>
    </el-button>

    <el-button type='primary' @click='sendReq'>Send Req</el-button>

    {{ msg }}
  </div>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {
      msg: 'Welcome to Your Vue.js App'
    };
  },
  methods: {
    sendReq() {
      this.$api.$get('/test').then(res => {
        this.msg = res;
      });
    },
  }

};
</script>

<style scoped>

</style>
