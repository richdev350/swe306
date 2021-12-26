<template>
  <div>
    <CustomPageTitle>
      Edit Reservation
    </CustomPageTitle>
    <MyReservationCard :key='id' :reservation='item' :is-operable='false' />
  </div>
</template>

<script>
export default {
  name: 'edit reserved',
  middleware: ['auth'],
  async asyncData({ store }) {
    await store.dispatch('room/fetchMyReservation');
    return {
      reservations: store.getters['room/myReservationList']
    };
  },
  data() {
    return {
      id: this.$route.params.id,
      // item: {
      //   'startTime': '2021-12-25 09:00:00',
      //   'endTime': '2021-12-25 10:00:00',
      //   'memberList': [
      //     '4',
      //     '5'
      //   ],
      //   'userId': 3,
      //   'roomId': 2,
      //   'reserveId': 1,
      //   'memberNum': 3,
      //   'status': 1
      // }
      item: {}
    };
  },
  mounted() {
    this.getItem();
  },
  methods: {
    async getItem() {
      const resp = await this.$api.$post('/getReservationByReserveId', {
        reserveId: this.id
      });
      if (resp.success) {
        this.item = resp.content;
      } else {
        this.$message.error(resp.message);
      }
    }
  }
};
</script>

<style scoped>

</style>
