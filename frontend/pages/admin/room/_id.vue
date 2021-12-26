<template>
  <div>
    <CustomPageTitle>Edit Room</CustomPageTitle>
    <RoomEditor method='update' :room-id='id'></RoomEditor>
  </div>
</template>

<script>
export default {
  name: 'edit room',
  middleware: ['adminAuth'],
  data() {
    return {
      id: parseInt(this.$route.params.id),
    };
  },
  methods: {
    handleBack() {
      this.$router.push('/admin/user');
    },
  }
};
</script>

<style scoped lang='scss'>


</style>
