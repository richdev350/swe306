<template>
  <div>
    <h2>Login</h2>
    <el-input v-model='user.username' prefix-icon='el-icon-user-solid' placeholder='Username'></el-input>
    <el-input v-model='user.password' prefix-icon='el-icon-lock' placeholder='Password'></el-input>
    <el-button
      type='primary'
      :loading='loading'
      @click='signin'>
      Sign in
    </el-button>
  </div>
</template>

<script>

export default {
  name: 'signin',
  middleware: ['auth'],
  data() {
    return {
      user: {
        username: '',
        password: ''
      },
      loading: false
    };
  },
  head() {
    return {
      title: 'Login'
    };
  },
  methods: {
    async signin() {
      this.loading = true;
      const { username, password } = this.user;
      try {
        const resp = await this.$store.dispatch('login', { username, password });
        if (resp.success) {
          await this.$router.push('/');
        } else {
          this.$message.error(resp.message);
        }
      } catch (err) {
        console.log(err);
      } finally {
        this.loading = false;
      }
    }
  }
};
</script>

<style scoped>

</style>
