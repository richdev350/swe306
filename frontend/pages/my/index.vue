<template>
  <div>
    <CustomPageTitle>Profile</CustomPageTitle>
    <MyInfoCard :user='currentUser' />
  </div>
</template>

<script>
export default {
  name: 'Profile',
  middleware: ['auth'],
  data() {
    return {};
  },
  head() {
    return {
      title: 'Profile'
    }
  },
  computed: {
    currentUser() {
      return this.$store.state.user;
    }
  }
};
</script>

<style scoped lang='scss'>

</style>
