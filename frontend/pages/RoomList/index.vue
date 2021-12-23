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
  data() {
    return {
      rooms: [
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
      ]
    };
  },
  head() {
    return {
      title: 'XMUM room Reservation',
      meta: [
        {
          hid: 'description',
          name: 'description',
          content: 'Available rooms for reservation'
        }
      ]
    };
  }
};
</script>

<style scoped lang='sass'>

</style>
