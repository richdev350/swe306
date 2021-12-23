<template>
  <div>
    <CustomPageTitle>
      My Reservation
    </CustomPageTitle>
  </div>
</template>

<script>
export default {
  name: 'MyReservation',
  middleware: ['auth'],
  head(){
    return{
      title: 'My Reservation'
    }
  }
};
</script>

<style scoped>

</style>
