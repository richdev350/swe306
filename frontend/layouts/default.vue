<template>
  <div class='main-container'>
    <HomeMainHeader />
    <div class='main-body'>
      <Nuxt />
    </div>
    <MainFooter />
  </div>
</template>

<style scoped lang='scss'>
.main-container {
  @apply px-52
}
</style>
<script>
import MainFooter from '@/components/home/MainFooter';

export default {
  components: { MainFooter }
};
</script>
