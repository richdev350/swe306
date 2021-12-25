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
  @apply md:px-20;
  @apply lg:px-32;
  @apply xl:px-48;
  //@apply sm:px-2;
  //@apply md:px-52;
  //@apply sm:bg-black;
  //@apply md:bg-red-400;
}

.main-body {
  @apply px-6
}
</style>
