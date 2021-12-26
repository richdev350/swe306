<template>
  <div class='login-card-wrapper'>
    <el-card>
      <CustomPageTitle align='center' size='h3'>Account Login</CustomPageTitle>
      <div @keyup.enter='login'>
        <div class='input'>
          <el-input v-model='user.username' prefix-icon='el-icon-user-solid' placeholder='Username'></el-input>
        </div>
        <div class='input'>
          <el-input v-model='user.password'
                    prefix-icon='el-icon-lock' placeholder='Password' show-password></el-input>
        </div>
        <el-button
          class='login-button'
          type='primary'
          :loading='loading'
          @click='login'>
          Sign in
        </el-button>
      </div>

    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      user: {
        username: '',
        password: ''
      },
      loading: false

    };
  },
  methods: {
    async login() {
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

<style scoped lang='scss'>
.input {
  //@apply inline-block;
  @apply mb-3;
}

.login-card-wrapper {
  //@apply min-w-fit;
  @apply max-w-sm;
}

.login-button {
  @apply mt-4;
  @apply w-full;
}
</style>
