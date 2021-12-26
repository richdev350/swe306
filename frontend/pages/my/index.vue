<template>
  <div>
    <CustomPageTitle>Profile</CustomPageTitle>
    <UserInfoCard :user='loggedInUser' />
    <el-button class='options' type='primary' @click='goEdit'>Edit Profile
    </el-button>
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
    };
  },
  computed: {
    ...mapGetters(['loggedInUser'])
  },
  methods: {
    goEdit() {
      this.$router.push('/my/edit');
    }
  }
};
</script>

<style scoped lang='scss'>
.room-card-wrapper {
  @apply flex flex-wrap flex-row justify-center;
}

.options {
  @apply mt-5;
}
</style>
