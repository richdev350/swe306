<template>
  <el-header class='nav' height='100px'>
    <el-menu
      :default-active='activeIndex'
      class='el-menu-demo'
      mode='horizontal'
      @select='handleSelect'>
      <el-menu-item index='1'>信息列表</el-menu-item>
      <el-submenu index='2'>
        <template slot='title'>我的预约</template>
        <el-menu-item index='2-1'>选项1</el-menu-item>
        <el-menu-item index='2-2'>选项2</el-menu-item>
        <el-menu-item index='2-3'>选项3</el-menu-item>
        <el-submenu index='2-4'>
          <template slot='title'>选项4</template>
          <el-menu-item index='2-4-1'>选项1</el-menu-item>
          <el-menu-item index='2-4-2'>选项2</el-menu-item>
          <el-menu-item index='2-4-3'>选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index='3' disabled>消息中心</el-menu-item>
      <el-menu-item index='4'><a href='https://www.ele.me' target='_blank'>订单管理</a></el-menu-item>
      <div class='test'>aaa</div>
    </el-menu>
  </el-header>
</template>


<script>
import { mapMutations } from 'vuex';

export default {
  name: 'MainHeader',
  data() {
    return {
      logo: 'assets/images/logo.png',
      auth: {
        username: '',
        password: ''
      }
    };
  },
  methods: {
    login() {
      console.log('username:', this.auth.username);
      console.log('password:', this.auth.password);
    },
    async sendReq({ $axios }) {
      const ip = await $axios.$get('http://icanhazip.com'); // http://tomcat/getRoom
      // address
      // datatype

      // json: room list
      return { ip };
    },
    ...mapMutations({})
  }
};
</script>

<style scoped lang='sass'>
$logo: url('assets/images/logo.png')

.logo

  .logo-image
    height: auto
    width: 100%
    text-align: center
    background-image: $logo
    background-size: cover
    filter: invert(100%)


</style>
