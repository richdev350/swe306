<template>
  <div>
    {{ id }}
  </div>
</template>

<script>
export default {
  middleware: ['auth'],
  data() {
    return {
      id: this.$route.params.id
    };
  }
};
</script>

<style scoped>

</style>
