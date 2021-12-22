<template>
  <nuxt-link to="/reservations">
    <div class='room'>
      <table>
        <thead>
        <tr>
          <th>RoomNo</th>
          <th>Location</th>
          <th>Room Name</th>
          <th>Min Capacity</th>
          <th>Max Capacity</th>
        </tr>
        </thead>

      </table>
      <p>{{ room}}</p>
    </div>
  </nuxt-link>
</template>

<script>
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
