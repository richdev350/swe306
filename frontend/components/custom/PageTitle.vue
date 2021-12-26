<template>
  <div :class='handleAlign'>
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
    },
    align: {
      type: String,
      default: null
    }
  },
  computed: {
    handleAlign() {
      let customClass = null;
      if (this.align === 'center') {
        customClass = `align--${ this.align }`;
      }
      return customClass;
    }
  }
};
</script>

<style scoped lang='scss'>
.title {
  @apply pb-3
}

.align--center {
  text-align: center;
}

.align--right {
  //
}

</style>
