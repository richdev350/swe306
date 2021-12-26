<template>
  <div>
    <CustomPageTitle>Add New User</CustomPageTitle>
    <UserEditor method='add'/>

  </div>
</template>

<script>
export default {
  name: 'add',
  middleware: ['adminAuth'],

};
</script>

<style scoped>

</style>
