<template>
  <div>
    <CustomPageTitle>Edit User</CustomPageTitle>
    <UserEditor :user-id='id' method='update'></UserEditor>
  </div>
</template>

<script>
export default {
  name: 'edit user',
  middleware: ['adminAuth'],

  data() {
    return {
      id: parseInt(this.$route.params.id)
    };
  },
  methods: {
    handleBack() {
      this.$router.push('/admin/user');
    }
  }
};
</script>

<style scoped lang='scss'>

</style>
