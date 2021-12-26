<template>
  <div>

    <el-form ref='form' :model='user' class='editor-form' label-width='100px'>
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
      <el-form-item v-if='method === "update" || method === "add"' label='Role'>
        <el-radio-group v-model='user.isAdmin'>
          <el-radio :label='1'>Admin</el-radio>
          <el-radio :label='0'>Student</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type='primary' @click='handleSubmit(user)'>Submit</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'User Editor',
  props: {
    method: {
      type: String,
      default: 'update',
      required: true
    },
    userId: {
      type: Number,
      required: false
    }
  },
  data() {
    return {
      user: {
        userId: null,
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
    if (this.method === 'update' || this.method === 'profile') {
      this.user.userId = this.userId;
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
      const resp = await this.$api.$post('/updateUser', {
        userId: user.userId,
        username: user.username,
        password: user.password,
        phoneNum: user.phoneNum,
        firstName: user.firstName,
        lastName: user.lastName,
        isAdmin: user.isAdmin
      });
      if (resp.success) {
        this.$message.success(resp.message);
        window.location.reload();
      } else {
        this.$message.error(resp.message);
      }
    },

    async addUser(user) {
      const resp = await this.$api.$post('/addUser', {
        username: user.username,
        password: user.password,
        phoneNum: user.phoneNum,
        firstName: user.firstName,
        lastName: user.lastName,
        isAdmin: user.isAdmin
      });
      if (resp.success) {
        this.$message.success(resp.message);
        window.location.reload();
      } else {
        this.$message.error(resp.message);
      }
    },

    handleSubmit(user) {
      if (this.method === 'update' || this.method === 'profile') {
        this.updateUser(user);
      }
      if (this.method === 'add') {
        this.addUser(user);
      }
    }
  }
};
</script>

<style scoped>

</style>
