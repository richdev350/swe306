<template>
  <div>
    <el-form ref='form' :model='room' class='editor-form' label-width='120px'>
      <el-form-item label='Room No.'>
        <el-input v-model='room.roomNo' placeholder='Room No.'></el-input>
      </el-form-item>
      <el-form-item label='Room Name'>
        <el-input v-model='room.roomName' placeholder='Room Name'></el-input>
      </el-form-item>

      <el-form-item label='Room Location'>
        <el-input v-model='room.location' placeholder='Location'></el-input>
      </el-form-item>
      <el-form-item label='Capacity'>
        <div class='w-80'>
          <el-col :span='11' class='capacity-input'>
            <el-input v-model='room.capacityMin' placeholder='Minimum'></el-input>
          </el-col>
          <el-col :span='2' class='line'>-</el-col>
          <el-col :span='11' class='capacity-input'>
            <el-input v-model='room.capacityMax' placeholder='Minimum'></el-input>
          </el-col>
        </div>
      </el-form-item>
      <el-form-item label='Status'>
        <el-radio-group v-model='room.status'>
          <el-radio :label='1'>Available</el-radio>
          <el-radio :label='0'>Unavailable</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type='primary' @click='handleSubmit(room)'>Submit</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Room Editor',
  props: {
    method: {
      type: String,
      default: 'update',
      required: true
    },
    roomId: {
      type: Number,
      required: false
    }
  },
  data() {
    return {
      room: {
        roomNo: null,
        location: null,
        roomName: null,
        roomId: null,
        status: null,
        capacityMin: null,
        capacityMax: null
      }
    };
  },
  mounted() {
    if (this.method === 'update') {
      this.room.roomId = this.roomId;
      this.getRoom();
    }
  },
  methods: {
    handleSubmit(room) {
      this.updateRoom(room);
    },
    handleBack() {
      this.$router.push('/admin/user');
    },
    async getRoom() {
      const resp = await this.$api.$post('/getRoom', { roomId: this.roomId });
      if (resp.success) {
        this.room = resp.content;
      } else {
        this.$message.error(resp.message);
      }
    },
    async updateRoom(room) {
      const resp = await this.$api.$post('/updateRoom', {
        roomId: room.roomId,
        roomNo: room.roomNo,
        location: room.location,
        roomName: room.roomName,
        status: room.status,
        capacityMin: parseInt(room.capacityMin),
        capacityMax: parseInt(room.capacityMax)
      });
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

<style scoped lang='scss'>
.capacity-input {
  @apply w-36;
  //@apply w-full;

}

.line {
  /*@apply w-2;*/
  text-align: center;
}

</style>
