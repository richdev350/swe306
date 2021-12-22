<template>
  <div class='main-container'>
    <HomeMainHeader />
    <div class='main-body'>
      <Nuxt />
    </div>
    <MainFooter />
  </div>
</template>

<script>
import MainFooter from '@/components/home/MainFooter';

export default {
  components: { MainFooter },
  async asyncData({ store, route }) {
    // await store.dispatch('FETCH_HOME_PAGE_DATA');
  },
};

</script>

<style scoped lang='scss'>
.main-container {
  @apply px-52
}
</style>
