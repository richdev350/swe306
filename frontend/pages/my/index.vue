<template>
  <div>
    <CustomPageTitle>Profile</CustomPageTitle>
    <MyInfoCard :user='currentUser' />
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

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
    ...mapGetters(['currentUser'])
  }
};
</script>

<style scoped lang='scss'>

</style>
