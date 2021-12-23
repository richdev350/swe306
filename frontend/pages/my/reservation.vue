<template>
  <div>
    <CustomPageTitle>My Reservation</CustomPageTitle>
    <MyInfo :user='currentUser' />
  </div>
</template>

<script>
export default {
  name: 'reservations',
  data() {
    return {};
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
