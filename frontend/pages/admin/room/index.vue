<template>
  <div>
    <CustomPageTitle>Room Management</CustomPageTitle>
    <div class='options'>
      <el-button type='primary' @click='handleAddRoom'>Add Room</el-button>
    </div>
    <el-table :data='roomList' stripe height='800'>
      <el-table-column
        type='index'
        fixed
        width='50'>
      </el-table-column>
      <el-table-column
        prop='roomNo'
        label='Room No'
        width='200'>
      </el-table-column>

      <el-table-column
        prop='roomName'
        label='Room Name'
        fit>
      </el-table-column>

      <el-table-column
        prop='location'
        label='Location'
        width='200'>
      </el-table-column>
      <el-table-column
        label='Capacity'
        width='100'>
        <template slot-scope='scope'>
          <div slot='reference' class='name-wrapper'>
            {{ scope.row.capacityMin + ' - ' + scope.row.capacityMax }}
          </div>
        </template>
      </el-table-column>
      <el-table-column
        label='Status'
        width='100'>
        <template slot-scope='scope'>
          <div slot='reference' class='name-wrapper'>
            <el-tag v-if='scope.row.status' type='success' size='small'>Available</el-tag>
            <el-tag v-else type='danger' size='small'>Unavailable</el-tag>
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
  name: 'room management',
  middleware: ['adminAuth'],
  async asyncData({ app }) {
    const resp = await app.$api.$get('/getRoomAll');
    let roomList = [];
    if (resp.success) {
      roomList = resp.content;
    } else {
      app.$message.error(resp.message);
    }
    return {
      roomList
    };
  },
  data() {
    return {
      roomList: []
    };
  },
  methods: {
    handleAddRoom() {
      this.$router.push('/admin/room/add');
    },
    handleEdit(index, row) {
      this.$router.push('/admin/room/' + row.roomId);
    }
  }
};
</script>

<style scoped lang='scss'>
.options {
  @apply float-right;
}

</style>
