<template>
  <div class='test'>
    <div>
      <el-input v-model='auth.username' placeholder='username'></el-input>
    </div>
    <div>
      <el-input
        v-model='auth.password'
        placeholder='password'
        show-password
      ></el-input>
    </div>
    <el-button type='primary' @click='login'>Login</el-button>
    <el-button type='secondary' @click='sendReq'>Test</el-button>
    {{ auth.username }}

  </div>
</template>

<script>
import { mapMutations } from 'vuex';

export default {
  name: 'Default',
  data() {
    return {
      auth: {
        username: '',
        password: ''
      }
    };
  },
  methods: {
    login() {
      console.log('username:', this.auth.username);
      console.log('password:', this.auth.password);
    },
    async sendReq({ $axios }) {
      const ip = await $axios.$get('http://icanhazip.com'); // http://tomcat/getRoom
      // address
      // datatype

      // json: room list
      return { ip };
    },
    ...mapMutations({})
  }
};
</script>

<style scoped lang='sass'>
.test
  max-width: 200px
</style>
