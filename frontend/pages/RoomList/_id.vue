<template>
  <div>
    <RoomCard :room='room' :is-operable='false' />
  </div>
</template>

<script>
export default {
  middleware: ['auth'],
  async asyncData({ app, route }) {
    const room = await app.$api.$post('/getRoom', { roomId: route.params.id });
    return {
      room: room.content
    };
  },
  data() {
    return {
      id: this.$route.params.id,
      room: Object
    };
  }
};
</script>

<style scoped>

</style>
