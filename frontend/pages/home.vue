<template>
  <div>
    <CustomPageTitle>Home</CustomPageTitle>
    <el-button>
      <NuxtLink to='test'>Test</NuxtLink>
    </el-button>

    <p>is authed: {{ isAuthenticated }}</p>
    <p>user: {{ loggedInUser }}</p>
    <p>cookie: {{ $cookies.getAll() }}</p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'Home',
  data() {
    return {
      msg: 'Welcome to Your Vue.js App'
    };
  },
  computed: {
    ...mapGetters(['isAuthenticated', 'loggedInUser'])
  },
  methods: {
    sendReq() {
      this.$api.$get('/test').then(res => {
        this.msg = res;
      });
    }
  }

};
</script>

<style scoped>

</style>
