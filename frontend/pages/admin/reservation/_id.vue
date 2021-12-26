<template>
  <div>
    <CustomPageTitle>Reservation Details</CustomPageTitle>
    <UserReservationCard :reservation='reservationInstance' :is-operable='false' />
  </div>
</template>

<script>
export default {
  name: 'reservation details',
  middleware: ['adminAuth'],
  async asyncData({ store, app, route }) {
    await store.dispatch('room/fetchMyReservation');
    const resp = await app.$api.$post('/getReservationByReserveId', {
      reserveId: route.params.id
    });
    let reservationInstance = {};
    if (resp.success) {
      reservationInstance = resp.content;
      // if (reservationInstance.status === 0) {
      //   await app.router.push('/my/reservation');
      // }
    } else {
      app.$message.error(resp.message);
    }
    return {
      reservationInstance,
      reservations: store.getters['room/myReservationList']
    };
  },
  data() {
    return {
      id: parseInt(this.$route.params.id)
    };
  },
  mounted() {
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
