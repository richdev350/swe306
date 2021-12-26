<template>
  <div>
    <CustomPageTitle>
      My Reservation
    </CustomPageTitle>
    <template v-for='item in reservations'>
      <UserReservationCard :key='item.reserveId' :reservation='item' />
    </template>
  </div>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  name: 'MyReservation',
  middleware: ['auth'],
  async asyncData({ store }) {
    await store.dispatch('room/fetchMyReservation');
    return {
      reservations: store.getters['room/myReservationList']
    };
  },
  data() {
    return {
      reservations: [],
      rooms: []
    };
  },
  head() {
    return {
      title: 'My Reservation'
    };

  },
  computed: {},
  methods:
    {
      ...mapActions('room', ['fetchRoom'])
    }
};
</script>

<style scoped>

</style>
