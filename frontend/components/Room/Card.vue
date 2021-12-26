<template>
  <div class='list-card-wrapper'>
    <el-card class='room-card' :shadow='shadow' :style='cardStyle'>
      <el-descriptions class='margin-top' :title='room.roomNo' :column='handleColumnNum' :size='descSize' border>
        <template v-if='isOperable' slot='extra'>
          <nuxt-link v-if='room.status' :to='"/RoomList/"+room.roomId'>
            <el-button type='primary' size='small' icon='el-icon-edit' :disabled='!room.status'>Make Reservation
            </el-button>
          </nuxt-link>
          <div v-if='!room.status'>
            <el-button type='primary' size='small' icon='el-icon-edit' :disabled='!room.status'>Make Reservation
            </el-button>
          </div>

        </template>
        <el-descriptions-item>
          <template slot='label'>
            <i class='el-icon-s-home'></i>
            Room Name
          </template>
          {{ room.roomName }}

        </el-descriptions-item>
        <el-descriptions-item>
          <template slot='label'>
            <i class='el-icon-s-help'></i>
            Capacity
            <el-tooltip effect='dark' content='minimum required number of members - max number of members'
                        placement='top'>
              <i class='el-icon-question'></i>
            </el-tooltip>

          </template>
          {{ room.capacityMin }} - {{ room.capacityMax }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot='label'>
            <i class='el-icon-tickets'></i>
            Status
          </template>
          <el-tag size='small' :type='roomStatusTag'>{{ roomStatus }}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot='label'>
            <i class='el-icon-location-outline'></i>
            Location
          </template>
          {{ room.location }}
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>

<script>

export default {
  name: 'Card',
  props: {
    room: {
      type: Object,
      required: true
    },
    isOperable: {
      type: Boolean,
      default: true
    },
    shadow: {
      type: String,
      default: 'hover'
    },
    border: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      descSize: ''
    };
  },
  computed: {
    cardStyle() {
      if (this.border) {
        return '';
      } else {
        return 'border: none;';
      }
    },
    roomStatus() {
      return this.room.status ? 'Available' : 'Unavailable';
    },
    roomStatusTag() {
      return this.room.status ? 'success' : 'danger';
    },
    handleColumnNum() {
      // TODO: screen size helper to adjust column number
      return 1;
    }
  },
  mounted() {
  }
};
</script>

<style scoped lang='scss'>
</style>
