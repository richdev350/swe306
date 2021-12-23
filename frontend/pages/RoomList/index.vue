<template>
  <div class='lg:h-full'>
    <CustomPageTitle>Room List</CustomPageTitle>
    <el-row>
      <el-col :span='8' v-for='item in rooms' :key='item.id' class='card_bottom'>
          <RoomCard  :room='item' />
      </el-col>
    </el-row>

  </div>
</template>

<script>


export default {
  middleware: ['auth'],
  async asyncData({ app }) {
    // can use $store to persist data
    const list = await app.$api.$post('/getRoomAll');
    return {
      rooms: list.content
    };
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
.card_bottom {
  margin-bottom: 50px;
}
</style>
