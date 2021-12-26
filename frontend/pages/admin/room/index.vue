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
        sortable
        width='200'>
      </el-table-column>

      <el-table-column
        prop='roomName'
        label='Room Name'
        sortable
        fit>
      </el-table-column>

      <el-table-column
        prop='location'
        label='Location'
        sortable
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
        sortable
        width='100'>
        <template slot-scope='scope'>
          <div slot='reference' class='name-wrapper'>
            <el-tag v-if='scope.row.status' type='success' size='small'>Available</el-tag>
            <el-tag v-else type='danger' size='small'>Unavailable</el-tag>
          </div>
        </template>
      </el-table-column>
      <el-table-column label='Action' fixed='right' width='200'>
        <template slot-scope='scope'>
          <el-button
            size='mini'
            @click='handleEdit(scope.$index, scope.row)'>Edit
          </el-button>
          <el-button
            size='mini'
            type='danger'
            @click='handleDelete(scope.$index, scope.row)'>Delete
          </el-button>

        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import Element from 'element-ui';

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
    },
    async handleDelete(index, row) {
      await Element.MessageBox.confirm(
        `Are you sure to delete room ${row.roomNo} ?`,
        'Attention',
        {
          type: 'warning',
          confirmButtonText: 'Yes',
          cancelButtonText: 'No'
        }
      )
        .then(async () => {
          const resp = await this.$api.$post('/deleteRoom', {
            roomId: row.roomId
          });
          if (resp.success) {
            Element.Message.success(resp.message);
            // await this.$router.push('/admin/room');
            window.location.reload();
          } else {
            Element.Message.error(resp.message);
          }
        })
        .catch(() => {
        });
    }

  }
};
</script>

<style scoped lang='scss'>
.options {
  @apply float-right;
}

</style>
