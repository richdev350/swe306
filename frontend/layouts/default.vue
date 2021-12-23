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
  }
};

</script>

<style scoped lang='scss'>
// TODO mixin with media queries
// TODO use tailwindcss
.main-container {
  @apply md:px-52;
  //@apply sm:bg-black;
  //@apply md:bg-red-400;
}

.main-body {
  @apply px-6
}
</style>
