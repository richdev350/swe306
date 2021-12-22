<template>
  <nuxt-link to="reservations">
    <div class='room'>
      <p>{{ room }}</p>
    </div>
  </nuxt-link>
</template>

<script>
/*import reservations from '../../pages/my/reservations';*/

export default {
  name: 'Room',
  props:["room",'id']
};
</script>

<style scoped lang='sass'>
.room
  padding: 1rem
  border: 1px dotted gray
  margin: 1rem 0
</style>
