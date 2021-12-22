<template>
  <div>
    <Room v-for='item in rooms'
          :key='item.id' :room='item' />
  </div>
</template>

<script>
import Room from '~/components/Room/Room';

export default {
  components: {
    Room
  },
  data() {
    return {
      rooms: [
        {
          id: 1,
          name: 'haha',
        },
        {
          id: 2,
          name: 'hahaha'
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
};
</script>

<style scoped lang='sass'>

</style>
