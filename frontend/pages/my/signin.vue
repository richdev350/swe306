<template>
  <div>
    <h2>Login</h2>
    <div class='login-wrapper'>
      <AuthLogin style='flex-grow: 1'></AuthLogin>
    </div>
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
      title: 'Signin'
    };
  },
  methods: {}
};
</script>

<style scoped lang='scss'>
.login-wrapper {
  @apply flex justify-center flex-row;
}
</style>
