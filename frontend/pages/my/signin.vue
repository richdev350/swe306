<template>
  <div>
    <el-input v-model='username' prefix-icon='el-icon-user-solid' placeholder='Username'></el-input>
    <el-input v-model='password' prefix-icon='el-icon-lock' placeholder='Password'></el-input>
    <el-button
      type='primary'
      @click='signin'
      :loading='loading'>
      Sign in
    </el-button>
    <el-button
      type='primary'
      @click='signup'
      :loading='loading'>
      Sign up
    </el-button>
    <el-button @click='myInfo'>MyInfo</el-button>
    <p>is authed: {{ isAuthenticated }}</p>
    <p>user: {{ loggedInUser }}</p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'signin',
  data() {
    return {
      username: '',
      password: '',
      loading: false
    };
  },
  computed: {
    ...mapGetters(['isAuthenticated', 'loggedInUser'])
  },
  methods: {
    async signin() {
      this.loading = true;
      const { username, password } = this;
      try {
        const resp = await this.$auth.loginWith('local', {
          data: {
            username,
            password
          }
        });
        console.log('signin resp:\n', resp);
      } catch (err) {
        this.$message.error(err.message);
      } finally {
        this.loading = false;
      }
    },
    async signup() {
      this.loading = true;
      const { username, password } = this;
      try {
        await this.$api.post('/api/signup', {
          username,
          password
        });
        const resp = await this.$auth.loginWith('local', {
          data: {
            username,
            password
          }
        });
        console.log(resp);
      } catch (err) {
        this.$message.error(err.message);
      } finally {
        this.loading = false;
      }
    }
    ,
    async myInfo() {
      try {
        const resp = await this.$api.get('/api/auth/myInfo');
        console.log(resp);
      } catch (err) {
        this.$message.error(err.message);
      }
    }
  }
};
</script>

<style scoped>

</style>
