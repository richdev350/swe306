<template>
  <div>
    <CustomPageTitle>Reservation Details</CustomPageTitle>
    <UserReservationCard :reservation='item' :is-operable='false' />
  </div>
</template>

<script>
export default {
  name: 'reservation details',
  middleware: ['adminAuth'],
  data() {
    return {
      id: parseInt(this.$route.params.id)
    };
  },
  mounted() {
    this.getReservationItem(this.id);
  },
  methods: {
    handleBack() {
      this.$router.push('/admin/user');
    },
    async getReservationItem(id) {
      // const resp = await
    }
  }
};
</script>

<style scoped lang='scss'>


</style>
