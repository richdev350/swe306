<template>
  <h2 class='title'>
    <slot></slot>
  </h2>
</template>

<script>
export default {
  name: 'Title'
};
</script>

<style scoped lang='scss'>
.title {
  @apply pb-3
}

</style>
