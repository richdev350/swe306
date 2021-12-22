<template>
  <nuxt-link to='reservations'>
    <div class='room'>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span><b>{{room.roomNo}}</b></span>
          <el-button style="float: right; padding: 3px 0" type="text">Click to make reservation</el-button>
        </div>
        <div class="text item">
          <p><b>Room Name: </b>{{ room.roomName}}</p>
          <el-divider></el-divider>
          <p><b>Room Location: </b>{{ room.location}}</p>
          <el-divider></el-divider>
          <p><b>Minimum Capacity: </b>{{room.capacityMin}}</p>
          <el-divider></el-divider>
          <p><b>Maximum Capacity: </b> {{room.capacityMax}}</p>
          <el-divider></el-divider>
          <p><b>Availability: </b> {{room.status}}</p>
        </div>
      </el-card>

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
.text
  font-size: 14px

  .item
    margin-bottom: 18px

  .clearfix:before,
  .clearfix:after
    display: table
    content: ""

  .clearfix:after
    clear: both

  .box-card
    width: 480px

</style>
