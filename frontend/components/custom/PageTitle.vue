<template>
  <div>
    <h2 v-if="size === 'h2'" class='title'>
      <slot></slot>
    </h2>

    <h3 v-if="size === 'h3'" class='title'>
      <slot></slot>
    </h3>
  </div>
</template>

<script>
export default {
  name: 'Title',
  props: {
    size: {
      type: String,
      default: 'h2'
    }
  }
};
</script>

<style scoped lang='scss'>
.title {
  @apply pb-3
}

</style>
