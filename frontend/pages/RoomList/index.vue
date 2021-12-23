<template>
  <div>
    <CustomPageTitle>Room List</CustomPageTitle>
    <template v-for='item in rooms' class='abc'>
      <RoomCard
        :key='item.id' :room='item' />
    </template>
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
      rooms: [],
      testRooms: [
        {
          roomNo: 1,
          location: 'hahadvjdiddddddijidjvidjvdjiovjdos',
          roomName: 'dcdcd',
          capacityMin: '3',
          capacityMax: '9',
          status: 'dvd'
        }
      ]
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
.abc {
  margin-bottom: 105px;
}
</style>
