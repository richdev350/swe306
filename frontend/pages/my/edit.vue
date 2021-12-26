<template>
  <div>
    <CustomPageTitle>Edit My Profile</CustomPageTitle>
    <UserEditor method='profile' :user-id='userId'></UserEditor>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'edit user info',
  computed: {
    userId() {
      return this.loggedInUser.id;
    },
    ...mapGetters(['loggedInUser'])
  }
};
</script>

<style scoped lang='scss'>

</style>
