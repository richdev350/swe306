<template>
  <div>
    <CustomPageTitle>User Management</CustomPageTitle>
    <el-table :data='userList' stripe height='800'>
      <el-table-column
        type='index'
        fixed
        width='50'>
      </el-table-column>
      <el-table-column
        prop='username'
        label='Username'
        fixed
        width='220'>
      </el-table-column>
      <el-table-column
        prop='firstName'
        fit
        label='First Name'
        width='220'>
      </el-table-column>
      <el-table-column
        prop='lastName'
        fit
        label='Last Name'
        width='220'>
      </el-table-column>
      <el-table-column
        prop='phoneNum'
        label='Tel.'
        width='200'>
      </el-table-column>

      <el-table-column
        label='Role'
        width='100'>
        <template slot-scope='scope'>
          <div slot='reference' class='name-wrapper'>
            <el-tag v-if='scope.row.isAdmin' type='info' size='small'>Admin</el-tag>
            <el-tag v-else type='primary' size='small'>Student</el-tag>
          </div>
        </template>
      </el-table-column>
      <el-table-column label='Action' fixed='right' width='100'>
        <template slot-scope='scope'>
          <el-button
            size='mini'
            @click='handleEdit(scope.$index, scope.row)'>Edit
          </el-button>
        </template>
      </el-table-column>

    </el-table>
  </div>
</template>

<script>
export default {
  name: 'user management',
  middleware: ['adminAuth'],
  async asyncData({ app }) {
    const resp = await app.$api.$get('/getUserAll');
    let userList = [];
    if (resp.success) {
      userList = resp.content;
    } else {
      app.$message.error(resp.message);
    }
    return {
      userList
    };
  },
  data() {
    return {
      userList: []
    };
  },
  methods: {
    handleEdit() {
      console.log('edit');
    }
  }
};
</script>

<style scoped>

</style>
