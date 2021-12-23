<template>
  <div>
    <el-alert
      :title='error.statusCode'
      type='error'
      :description='error.message'
      show-icon>
    </el-alert>
  </div>
</template>

<script>
export default {
  name: 'Error',
  layout: 'error',
  props: ['error'],
  data() {
    return {};
  }
};
</script>

<style scoped lang='scss'>

</style>
