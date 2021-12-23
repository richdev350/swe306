<template>
  <div>
    <RoomCard :room='room' />
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
      room: null
    };
  }
};
</script>

<style scoped>

</style>
