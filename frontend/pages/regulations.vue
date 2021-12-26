<template>
  <div class='my-20'>
    <div class=''></div>
    <el-card class='box-card'>
      <CustomPageTitle align='center'>
        XMUM Room Reservation Rules
      </CustomPageTitle>
      <el-divider content-position='center'><span class='title1'><span
        class='el-icon-s-tools'> Reservation Regulations</span></span></el-divider>
      <div class='text item'>
        1. XMUM Online Reservation system is only open to XMUM students and staff for academic purposes.
        <span class='emphasis'>Any activities that are not academic related are strictly forbidden.</span>
      </div>
      <div class='text item'>
        2. Room reservation is limited within the classroom/library operation time <b>from 08:00 to 23:00</b> (Public
        holidays are not included).
        <span class='emphasis'> Any reservation beyond the operation time will not be allowed.</span>
      </div>
      <div class='text item'>
        3. After the reservations are successfully made, all group members must confirm sign-in at the Discussion Room
        Counter within first 30min of the reserved time period.
        <span class='emphasis'>If the room still empty within the first 30 min of the reserved time, the Librarian has the right to cancel the booking immediately.</span>
      </div>
      <div class='text item'>
        4. Only <b>ONE</b> room of each reservation is allowed for each student.
        <span class='emphasis'> If the number of members are smaller than the minimum capacity of the room, the reservation will not be permitted.</span>
      </div>
      <el-divider content-position='center'><span class='title1'><span
        class='el-icon-warning'> Prohibited Behaviours</span></span>
      </el-divider>
      <div class='text item'>
        <b>1. Food is not permitted.</b>
      </div>
      <div class='text item'>
        <b>2. Loud noises.</b>
      </div>
      <div class='text item'>
        <b>3. Playing of cards/games/gambling.</b>
      </div>
      <div class='text item'>
        <b>4. Leaving personal belongings unattended.</b>
      </div>
      <div class='text item'>
        <b>5. Bringing in additional chairs/other pieces of furniture.</b>
      </div>
      <div class='text item'>
        <b>6. Leaving any kind of garbage including paper/plastic, etc.</b>
      </div>
      <el-divider content-position='center'><span class='title1'><span class='el-icon-paperclip'> Tips</span></span>
      </el-divider>
      <div class='text item'>
        1. Please unplug the projector after use.
      </div>
      <div class='text item'>
        2. If you need to use HDMI to VGA convertor, please bring your campus card to the Discussion Room Counter to
        borrow
        it, and return in time after use.
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  head() {
    return {
      title: 'XMUM Reservation Rules'
    };
  }
};
</script>

<style scoped lang='scss'>
.title1 {
  color: dimgray;
  font-size: 25px;
}

.emphasis {
  color: brown;
  font-weight: bold;
}

.clearfix {
  font-size: 30px;
}

.item {
  margin-bottom: 20px;
}

.text {
  font-size: 24px;

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both;
  }

  .box-card {
    width: 480px;
  }
}


</style>
