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
    <el-button
      @click='logout'>
      Log out
    </el-button>
    <el-button
      @click='testReq'>
      secured req
    </el-button>
    <p>is authed: {{ isAuthenticated }}</p>
    <p>user: {{ loggedInUser }}</p>
    <p>cookie: {{ $cookies.getAll() }}</p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'signin',
  middleware:['auth'],
  data() {
    return {
      user: {
        username: '',
        password: ''
      },
      loading: false
    };
  },
  computed: {
    ...mapGetters(['isAuthenticated', 'loggedInUser'])
  },
  methods: {
    async signin() {
      this.loading = true;
      const { username, password } = this.user;
      try {
        const resp = await this.$store.dispatch('login', { username, password });
        console.log('resp: \n', resp);
        // this.$router.push('/');
      } catch (err) {
        this.$message.error(err.message);
      } finally {
        this.loading = false;
      }
    },
    logout() {
      this.$store.dispatch('logout');
    },
    testReq() {
      this.$api.$get('/auth/user').then(resp => {
        console.log('resp: \n', resp);
      }).catch(err => {
        console.log(err);
        this.$message.error(err.message);
      });
    }
    // async signup() {
    //   this.loading = true;
    //   const { username, password } = this;
    //   try {
    //     await this.$api.post('/api/signup', {
    //       username,
    //       password
    //     });
    //     const resp = await this.$auth.loginWith('local', {
    //       data: {
    //         username,
    //         password
    //       }
    //     });
    //     console.log(resp);
    //   } catch (err) {
    //     this.$message.error(err.message);
    //   } finally {
    //     this.loading = false;
    //   }
    // }
    // ,
    // async myInfo() {
    //   try {
    //     const resp = await this.$api.get('/auth/user');
    //     console.log(resp);
    //   } catch (err) {
    //     this.$message.error(err.message);
    //   }
    // }
  }
};
</script>

<style scoped>

</style>
