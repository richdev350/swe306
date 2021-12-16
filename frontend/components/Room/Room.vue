<template>
<div class='room'>
  <p>{{ room }}</p>
</div>
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
