<template>
  <el-card shadow='hover'>
    <div class='header'>
      <h3>My Profile</h3>
    </div>
    <el-row type='flex' justify='start'>
      <el-col class='key-name' :span='spanleft'>
        <i class='el-icon-user-solid'></i>
        Student ID
      </el-col>
      <el-divider direction='vertical'></el-divider>
      <el-col class='val-name'>{{ currentUser.username }}</el-col>
    </el-row>

    <el-row type='flex'>
      <el-col class='key-name' :span='spanleft'>
        <i class='el-icon-s-opportunity'></i>
        Name
      </el-col>
      <el-divider direction='vertical'></el-divider>
      <el-col class='val-name'>{{ currentUser.name }}</el-col>
    </el-row>

    <el-row type='flex'>
      <el-col class='key-name' :span='spanleft'>
        <i class='el-icon-phone'></i>
        Phone
      </el-col>
      <el-divider direction='vertical'></el-divider>
      <el-col class='val-name'>{{ currentUser.phoneNum }}</el-col>
    </el-row>
    <el-row type='flex'>
      <el-col class='key-name' :span='spanleft'>
        <i class='el-icon-s-tools'></i>
        Role
      </el-col>
      <el-divider direction='vertical'></el-divider>
      <el-col class='val-name'>{{ currentUser.role }}</el-col>
    </el-row>

  </el-card>
</template>

<script>
export default {
  name: 'info',
  props: ['user'],
  data() {
    return {
      spanleft: 3,
      spanright: 6
    };
  },
  computed: {
    currentUser() {
      const user = this.user;
      return {
        // todo: can i define everything in one file (to avoid repetition and modification)?
        id: user.userId,
        username: user.username,
        name: user.firstName + ' ' + user.lastName,
        phoneNum: user.phoneNum,
        role: user.isAdmin ? 'Admin' : 'Student'
      };
    }
  }

};
</script>

<style scoped lang='scss'>
.header {
  @apply pb-3
}

.key-name {
  width: 10%;
}

.val-name {
  padding-left: 3px;
}

</style>
