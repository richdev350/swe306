<template>
  <nuxt-link to='reservations'>
    <div class='room'>
      <p>{{ room.id }}</p>
      <p>{{ room.name }}</p>
      <p>{{ room.something }}</p>
    </div>
  </nuxt-link>
</template>

<script>

export default {
  name: 'Room',
  props: ['room']
};
</script>

<style scoped lang='sass'>
.room
  padding: 1rem
  border: 1px dotted gray
