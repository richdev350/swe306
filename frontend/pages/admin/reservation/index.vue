<template>
  <div>
    <CustomPageTitle>Reservation Management</CustomPageTitle>
    <el-table :data='reservationDisplayList' stripe height='800'>
      <el-table-column
        prop='reservationDisplayList.roomName'
        type='Room Name'
        fixed
        width='50'>
      </el-table-column>
      <el-table-column
        prop='reservationDisplayList.date'
        label='Date'
        width='200'>
      </el-table-column>

      <el-table-column
        prop='reservationDisplayList.roomName'
        label='Time'
        fit>
      </el-table-column>

      <el-table-column
        prop='reservationDisplayList.status'
        label='Status'
        width='200'>
      </el-table-column>
      <el-table-column
        label='Capacity'
        width='100'>
        aaa
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
            @click='handleView(scope.$index, scope.row)'>
            View
          </el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
export default {
  name: 'Reservation Management',
  middleware: ['adminAuth'],
  async asyncData({ store }) {
    await store.dispatch('room/fetchMyReservation');
    return {
      reservations: store.getters['room/myReservationList']
    };
  },
  data() {
    return {
      reservations: [],
      reservationDisplayList: [
        {
          reserveId: '',
          roomId: '',
          roomName: '',
          date: '',
          startTime: '',
          endTime: '',
          status: ''
        }
      ]
    };
  },
  mounted() {
    this.getRoom().then(() => {
      this.getMembers();
    });
  },
  methods: {
    handleView(index, row) {
      // console.log(row.userId);
      this.$router.push('/admin/reservation/' + row.userId);
    },
    async getRoom(roomId) {
      const resp = await this.$api.$post('/getRoom', { roomId });
      if (resp.success) {
        this.room = resp.content;
      } else {
        this.$message.error(resp.message);
      }
    }

  }

};
</script>

<style scoped lang='scss'>
.options {
  @apply flex justify-end;
}

</style>
