<template>
  <div>
    <CustomPageTitle>Add New User</CustomPageTitle>
    <RoomEditor method='add'/>

  </div>
</template>

<script>
export default {
  name: 'add room',
  middleware: ['adminAuth'],

};
</script>

<style scoped>

</style>
