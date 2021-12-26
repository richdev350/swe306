<template>
  <div>

    <el-form ref='form' :model='user' class='reservation-form' label-width='100px'>
      <el-form-item label='Username'>
        <el-input v-model='user.username'></el-input>
      </el-form-item>
      <el-form-item label='First Name'>
        <el-input v-model='user.firstName'></el-input>
      </el-form-item>
      <el-form-item label='Last Name'>
        <el-input v-model='user.lastName'></el-input>
      </el-form-item>
      <el-form-item label='Password'>
        <el-input v-model='user.password' show-password></el-input>
      </el-form-item>
      <el-form-item label='Tel.'>
        <el-input v-model='user.phoneNum'></el-input>
      </el-form-item>
      <el-form-item label='Role'>
        <el-radio-group v-model='user.isAdmin'>
          <el-radio :label='1'>Admin</el-radio>
          <el-radio :label='0'>Student</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type='primary' @click='updateUser'>Submit</el-button>
      </el-form-item>
      {{ user }}
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'User Editor',
  props: {
    userId: {
      type: String,
      required: true
    },
    method: {
      type: String,
      default: 'update',
      required: true
    }
  },
  data() {
    return {
      user: {
        userId: this.userId,
        username: null,
        password: null,
        firstName: null,
        lastName: null,
        phoneNum: null,
        isAdmin: null
      }
    };
  },
  mounted() {
    if (this.method === 'update') {
      this.getUser();
    }
  },
  methods: {
    async getUser() {
      const resp = await this.$api.$post('/getUser', {
        userId: this.userId
      });
      if (resp.success) {
        const user = resp.content;
        this.user.username = user.username;
        this.user.password = user.password;
        this.user.phoneNum = user.phoneNum;
        this.user.firstName = user.firstName;
        this.user.lastName = user.lastName;
        this.user.isAdmin = user.isAdmin;
      } else {
        this.$message.error(resp.message);
      }
    },
    async updateUser(user) {
      const resp = await this.$api.$post('/updateUser', { user });
      if (resp.success) {
        this.$message.success(resp.message);
        window.location.reload();
      } else {
        this.$message.error(resp.message);
      }
    }

  }
};
</script>

<style scoped>

</style>
