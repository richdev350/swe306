<template>
  <div class='room-card-wrapper'>
    <el-card class='room-card'>
      <el-descriptions class='margin-top' :column='handleColumnNum' :size='descSize' border>
          <div class='header'>
            <h3>My Profile</h3>
          </div>
          <el-descriptions-item>
            <template slot='label'>
              <i class='el-icon-user-solid'></i>
              Student ID
            </template>
            {{ loggedInUser.username }}
          </el-descriptions-item>

          <el-descriptions-item>
            <template slot='label'>
              <i class='el-icon-s-opportunity'></i>
              Name
            </template>
            {{ loggedInUser.fullName }}
          </el-descriptions-item>

          <el-descriptions-item>
            <template slot='label'>
              <i class='el-icon-phone'></i>
              Phone
            </template>
            {{ loggedInUser.phoneNum }}
          </el-descriptions-item>

          <el-descriptions-item>
            <template slot='label'>
              <i class='el-icon-s-tools'></i>
              Role
            </template>
            {{ loggedInUser.role }}
          </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>
<!--      <el-row type='flex' justify='start'>
        <el-col class='key-name' :span='spanleft'>
          <i class='el-icon-user-solid'></i>
          Student ID
        </el-col>
        <el-divider direction='vertical'></el-divider>
        <el-col class='val-name'>{{ loggedInUser.username }}</el-col>
      </el-row>-->

<!--      <el-row type='flex'>
        <el-col class='key-name' :span='spanleft'>
          <i class='el-icon-s-opportunity'></i>
          Name
        </el-col>
        <el-divider direction='vertical'></el-divider>
        <el-col class='val-name'>{{ loggedInUser.fullName }}</el-col>
      </el-row>-->

<!--      <el-row type='flex'>
        <el-col class='key-name' :span='spanleft'>
          <i class='el-icon-phone'></i>
          Phone
        </el-col>
        <el-divider direction='vertical'></el-divider>
        <el-col class='val-name'>{{ loggedInUser.phoneNum }}</el-col>
      </el-row>-->
<!--      <el-row type='flex'>
        <el-col class='key-name' :span='spanleft'>
          <i class='el-icon-s-tools'></i>
          Role
        </el-col>
        <el-divider direction='vertical'></el-divider>
        <el-col class='val-name'>{{ loggedInUser.role }}</el-col>
      </el-row>-->


<script>
import { mapGetters } from 'vuex';

export default {
  name: 'info',
  props: ['user'],
  data() {
    return {
      spanleft: 3,
      spanright: 6,
      descSize: ''

    };
  },
  computed: {
    ...mapGetters(['loggedInUser']),
    // loggedInUser() {
    //   const user = this.user;
    //   return {
    //     // todo: can i define everything in one file (to avoid repetition and modification)?
    //     id: user.userId,
    //     username: user.username,
    //     name: user.firstName + ' ' + user.lastName,
    //     phoneNum: user.phoneNum,
    //     role: user.isAdmin ? 'Admin' : 'Student'
    //   };
    // }
    cardStyle() {
      if (this.border) {
        return '';
      } else {
        return 'border: none;';
      }
    },
    handleColumnNum() {
      // TODO: screen size helper to adjust column number
      return 1;
    }
  }

};
</script>

<style scoped lang='scss'>
.room-card-wrapper {
  @apply flex flex-wrap flex-row justify-center;
}
.header {
  @apply pb-3
}
.room-card {
  @apply flex-grow;
}

.key-name {
  width: 10%;
}

.val-name {
  padding-left: 3px;
}

</style>
