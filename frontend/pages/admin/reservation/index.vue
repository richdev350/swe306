<template>
  <div>
    <CustomPageTitle>Reservation Management</CustomPageTitle>
    <el-table :data='reservationDisplayList' stripe height='800'>
      <el-table-column
        type='index' width='50'></el-table-column>
      <el-table-column
        prop='roomName'
        label='Room Name'
        sortable
        fit>
      </el-table-column>

      <el-table-column
        prop='mainUser'
        label='Reserved By'
        sortable
        width='200'>
      </el-table-column>

      <el-table-column
        prop='date'
        label='Date'
        sortable
        width='200'>
      </el-table-column>

      <el-table-column
        prop='timeRange'
        label='Time'
        sortable
        fit>
      </el-table-column>

      <el-table-column
        label='Status'
        width='100'>
        <template slot-scope='scope'>
          <div slot='reference' class='name-wrapper'>
            <el-tag v-if='scope.row.status' type='success' size='small'>Used</el-tag>
            <el-tag v-else type='warning' size='small'>Unused</el-tag>
          </div>
        </template>
      </el-table-column>
      <el-table-column label='Action' width='100'>
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
  async asyncData({ app, store }) {
    const resp = await app.$api.$get('/getReservationAll');
    const ReservationList = resp.content;
    if (resp.success && ReservationList.length > 0) {
      return { reservations: ReservationList };
    } else {
      app.$message.error(resp.message);
    }
  },
  data() {
    return {
      reservations: [],
      reservationDisplayList: [
        // {
        //   reserveId: '',
        //   roomId: '',
        //   roomName: '',
        //   date: '',
        //   startTime: '',
        //   endTime: '',
        //   status: '',
        //   mainUser: ''
        // }
      ]
    };
  },
  mounted() {
    const list = [];
    this.reservations.forEach(reservation => {
      console.log(reservation);
      this.getRoom(reservation.roomId).then(room => {
        console.log(room);
        this.getUser(reservation.userId).then(user => {
          console.log(user);
          list.push({
            reserveId: reservation.reserveId,
            roomId: reservation.roomId,
            roomName: room.roomName,
            date: reservation.startTime.split(' ')[0],
            timeRange: reservation.startTime.split(' ')[1] + ' - ' + reservation.startTime.split(' ')[1],
            status: reservation.status,
            mainUser: user.username
          });
          this.reservationDisplayList = list;
        });
      });
    });
  },
  methods: {
    handleView(index, row) {
      // console.log(row.userId);
      this.$router.push('/admin/reservation/' + row.reserveId);
    },
    async getRoom(roomId) {
      const resp = await this.$api.$post('/getRoom', { roomId });
      if (resp.success) {
        return resp.content;
      } else {
        this.$message.error(resp.message);
      }
    },
    async getUser(userId) {
      const resp = await this.$api.$post('/getUser', {
        userId
      });
      if (resp.success) {
        return resp.content;
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
