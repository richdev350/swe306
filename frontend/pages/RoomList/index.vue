<template>
  <div class=''>
    <CustomPageTitle>Room List</CustomPageTitle>
    <div v-for='item in rooms'
         :key='item.id' class='room-card-item'>
      <div>
        <RoomCard :room='item' />
      </div>
    </div>

  </div>
</template>

<script>


export default {
  middleware: ['auth'],
  async asyncData({ store }) {
    await store.dispatch('room/fetchRoomList');
    return { rooms: store.getters['room/roomList'] };
  },
  data() {
    return {
      rooms: []
    };
  },
  head() {
    return {
      title: 'XMUM Room Reservation',
      meta: [
        {
          hid: 'description',
          name: 'description',
          content: 'Available rooms for reservation'
        }
      ]
    };
  },

  methods: {}

};
</script>

<style scoped lang='scss'>
.card_bottom {
  margin-bottom: 50px;
}

.room-card-item {
  @apply m-3.5;
}
</style>
