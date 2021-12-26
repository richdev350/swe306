<template>
  <div>
    <CustomPageTitle>Edit User</CustomPageTitle>
    <el-form ref='form' :model='room' class='editor-form' label-width='100px'>
      <el-form-item label='Room No.'>
        <el-input v-model='room.roomNo' placeholder='Room No.'></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'edit room',
  middleware: ['adminAuth'],
  data() {
    return {
      id: parseInt(this.$route.params.id),
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
  methods: {
    handleBack() {
      this.$router.push('/admin/user');
    }
  }
};
</script>

<style scoped lang='scss'>

</style>
