<template>
  <div>
    <CustomPageTitle>Room List</CustomPageTitle>

    <Room v-for='item in rooms'
          :key='item.id' :room='item' />
  </div>
</template>

<script>
import Room from '~/components/room/Room';

export default {
  components: {
    Room
  },
  middleware: ['auth'],
  async asyncData({ store, route, app }) {
    // await store.dispatch('room/getRoomList');
    const list = await app.$api.$post('/getRoomAll');
    return {
      rooms: list.content
    };
  },
  data() {
    return {
      testRooms: [
        {
          roomNo: 1,
          location: 'hahadvjdiddddddijidjvidjvdjiovjdos',
          roomName: 'dcdcd',
          capacityMin: '3',
          capacityMax: '9',
          status: 'dvd'
        },
        {
          roomNo: 2,
          location: 'haha',
          roomName: 'dcdcd',
          capacityMin: '3',
          capacityMax: '9',
          status: 'dvd'
        },
        {
          roomNo: 3,
          location: 'haha',
          roomName: 'dcdcd',
          capacityMin: '3',
          capacityMax: '9',
          status: 'dvd'
        },
        {
          roomNo: 4,
          location: 'haha',
          roomName: 'dcdcd',
          capacityMin: '3',
          capacityMax: '9',
          status: 'dvd'
        },
        {
          roomNo: 5,
          location: 'haha',
          roomName: 'dcdcd',
          capacityMin: '3',
          capacityMax: '9',
          status: 'dvd'
        }
      ],
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

<style scoped lang='sass'>

</style>
