<template>
  <div class='main-container'>
    <HomeMainHeader />
    <div class='main-body'>
      <Nuxt />
    </div>
    <HomeMainFooter />
  </div>
</template>

<script>

export default {
  async asyncData({ store, route }) {
    // await store.dispatch('FETCH_HOME_PAGE_DATA');
  }
};

</script>

<style scoped lang='scss'>
// TODO mixin with media queries
.main-container {
  @apply px-52
}

.main-body {
  @apply px-6
}
</style>
