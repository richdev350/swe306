<template>
  <div class=''>
    <CustomPageTitle>Room List</CustomPageTitle>

    <div class='my-10 ml-20 mr-0 grid sm:grid-cols-1 md:grid-cols-2 xl:grid-cols-3'>
      <div class= 'flex mb-20 md:flex-col md:mx-10 xl:mt-15 mx-15'
        v-for='item in rooms' :key='item.id'  >
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
.container{

}
</style>
