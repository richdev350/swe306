<template>
  <div>
    <el-card shadow='never' class='resv-card'>
      <RoomCard :is-operable='false' :room='room' :border='false' shadow='never' />
      <el-descriptions class='resv-details'>
        <el-descriptions-item label='Members'>
          <el-tag v-for='member in members' :key='member.userId'
                  size='small'
                  class='member-tag'>
            {{ member.firstName + ' ' + member.lastName + ' (' + member.username + ')' }}
          </el-tag>

        </el-descriptions-item>
        <el-descriptions-item>
          <el-date-picker
            v-model='timeRange'
            type='datetimerange'
            range-separator='至'
            start-placeholder='开始日期'
            end-placeholder='结束日期'>
          </el-date-picker>
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>

<script>

export default {
  name: 'MyReservationCard',
  props: {
    reservation: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      descSize: '',
      room: {},
      members: []
    };
  },
  computed: {
    timeRange() {
      return [this.reservation.startTime, this.reservation.endTime];
    }
  },
  mounted() {
    this.getRoom().then(() => {
      this.getMembers();
    });
  },
  methods: {
    handleColumnNum() {
      // TODO: screen size helper to adjust column number
      return 1;
    },
    async getRoom() {
      const resp = await this.$api.$post('/getRoom', { roomId: this.reservation.roomId });
      if (resp.success) {
        this.room = resp.content;
      } else {
        this.$message.error(resp.message);
      }
    },
    getMembers() {
      const memberIdList = this.reservation.memberList;
      memberIdList.forEach(async (memberId) => {
        memberId = parseInt(memberId);
        const resp = await this.$api.$post('/getUser', { userId: memberId });
        if (resp.success) {
          this.members.push(resp.content);
        } else {
          this.$message.error(resp.message);
        }
      });
    }
  }
};
</script>

<style scoped lang='scss'>
.member-tag {
  @apply mr-2;
}

.resv-details {
  @apply m-3;
}
</style>
