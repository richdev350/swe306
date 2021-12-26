<template>
  <div>
    <CustomPageTitle>Profile</CustomPageTitle>
    <MyInfoCard :user='loggedInUser' />
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
    ...mapGetters(['loggedInUser'])
  }
};
</script>

<style scoped lang='scss'>
.room-card-wrapper {
  @apply flex flex-wrap flex-row justify-center;
}
</style>
