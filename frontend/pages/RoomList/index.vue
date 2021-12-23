<template>
  <div class='lg:h-full'>
    <CustomPageTitle>Room List</CustomPageTitle>
    <el-row>
      // FIXME dont use el-col
      <el-col v-for='item in rooms' :key='item.id' :span='8' class='card_bottom'>
        <RoomCard :room='item' />
      </el-col>
    </el-row>

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
</style>
