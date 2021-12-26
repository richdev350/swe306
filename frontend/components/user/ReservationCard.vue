<template>
  <div>
    <el-card shadow='never' class='resv-card'>
      <RoomCard :is-operable='false' :room='room' :border='false' shadow='never' />
      <el-descriptions class='resv-details' title='Reservation Details'
                       :column='1'
                       :label-style='{"align-items": "center"}'
                       :colon='false'
      >
        <template v-if='isOperable' slot='extra'>
          <nuxt-link v-if='reservation.status' :to='"/edit/reserved/"+reservation.reserveId'>
            <el-button type='primary' size='small' icon='el-icon-edit' :disabled='!room.status'>
              Edit
            </el-button>
          </nuxt-link>

        </template>
        <el-descriptions-item label='Time'>
          <el-date-picker
            v-model='timeRange'
            type='datetimerange'
            range-separator='-'
            start-placeholder='Start'
            end-placeholder='End'
            readonly
          >
          </el-date-picker>
        </el-descriptions-item>
        <el-descriptions-item label='Members'>
          <el-tag v-for='member in members' :key='member.userId'
                  size='small'
                  class='member-tag'>
            {{ member.firstName + ' ' + member.lastName + ' (' + member.username + ')' }}
          </el-tag>

        </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>

<script>

export default {
  name: 'UserReservationCard',
  props: {
    reservation: {
      type: Object,
      required: true
    },
    isOperable: {
      type: Boolean,
      default: true
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
  @apply mt-3;
  @apply mx-5
}

.resv-card {
  @apply mb-3;
}
</style>
