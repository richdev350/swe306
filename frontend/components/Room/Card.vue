<template>
  <nuxt-link to='/reservations'>
    <div class='room'>
      <el-card class='box-card' shadow='hover'>
        <div slot='header' class='clearfix'>
          <span class='roomID'><b>{{ room.roomNo }}</b></span>
        </div>
        <div class="bottom clearfix">
        <div class='text item'>
          <p><b>Room Name: </b>{{ room.roomName }}</p>
          <el-divider></el-divider>
          <p><b>Room Location: </b>{{ room.location }}</p>
          <el-divider></el-divider>
          <p><b>Minimum Capacity: </b>{{ room.capacityMin }}</p>
          <el-divider></el-divider>
          <p><b>Maximum Capacity: </b>{{ room.capacityMax }}</p>
          <el-divider></el-divider>
          <p><b>Availability: </b>{{ room.status }}</p>
        </div>
        </div>
      </el-card>
    </div>
  </nuxt-link>
</template>

<script>

export default {
  name: 'Card',
  props: ['room']
};
</script>

<style scoped lang='scss'>
.roomID{
  font-size: 30px;
}
.text {
  font-size: 20px;
}
.bottom {
  margin-top: 15px;
  line-height: 12px;
}

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }

</style>
