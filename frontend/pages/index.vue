<template>
  <div>

    <el-button @click='login'>
      fake
    </el-button>
    <el-button>
      <NuxtLink to='test'>Test</NuxtLink>
    </el-button>

    <el-button type='primary' @click='sendReq'>Send Req</el-button>

    {{ msg }}
  </div>
</template>

<script>
export default {
  name: 'Index',
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
    login() {
      this.$store.dispatch('fakeLogin');
    }
  }

};
</script>

<style scoped>

</style>
