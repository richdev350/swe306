<template>
  <el-header class='nav' height='100px'>
    <el-row type='flex' :gutter='10'>
      <el-col class='logo-wrapper' :xs='0' :sm='0' :md='3' :lg='5'>
        <a href='/'>
          <el-image fit='scale-down' class='logo-image'
                    :src='logoSrc'></el-image>
        </a>
      </el-col>
      <el-col>
        <el-menu
          :default-active='routePath'
          class='el-menu-demo'
          mode='horizontal'
          router
        >
          <template v-for='item in menuItems'>
            <el-menu-item v-if='item.status' :key='item.index' :index='item.index'>
              {{ item.title }}
            </el-menu-item>
          </template>
          <el-submenu v-if='currentUser.role === "Admin"' index='/admin'>
            <template slot='title'>
              <span>Admin</span>
            </template>
            <el-menu-item index='/my/reservation'>
              My Reservation
            </el-menu-item>
          </el-submenu>
          <el-submenu v-if='isAuthenticated' index='/my'>
            <template slot='title'>
              <span>{{ currentUser.fullName }}</span>
            </template>
            <el-menu-item index='/my/reservation'>
              My Reservation
            </el-menu-item>
            <el-menu-item index='/my'>
              Profile
            </el-menu-item>
            <el-menu-item index='/my/signin' @click='logout'>
              Logout
            </el-menu-item>
          </el-submenu>
          <el-menu-item v-if='!isAuthenticated' index='/my/signin'>
            Login
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>

  </el-header>
</template>


<script>

import { mapGetters } from 'vuex';

export default {
  name: 'MainHeader',
  data() {
    return {
      logoSrc: 'https://s3.bmp.ovh/imgs/2021/12/74fbc09da57978e6.png',
      menuItems: [
        {
          index: '/home',
          title: 'Home',
          status: true
        },
        {
          index: '/RoomList',
          title: 'Room List',
          status: true
        },
        {
          index: '/regulations',
          title: 'Regulations',
          status: true
        }
      ]
    };
  },
  computed: {
    routePath() {
      return this.$nuxt.$route.path;
    },
    ...mapGetters(['currentUser', 'isAuthenticated'])

  },
  methods: {
    logout() {
      this.$store.dispatch('logout');
      this.$router.push('/');
    }
  }
};
</script>

<style scoped lang='scss'>
//$logo: url('assets/images/logo.png')

.logo-wrapper {
  //@apply sm:hidden;
  @apply flex;
  @apply justify-center;
  padding-top: 15px;

  .logo-image {
    height: 80%;
  }
}

//.logo-image
//  height: auto
//  width: 100%
//  text-align: center
//  background-image: $logo
//  background-size: cover
//  filter: invert(100%)


.nav {
  $var: -20px;
  margin-left: $var;
  margin-right: $var;
}
</style>
