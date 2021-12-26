<template>
  <div>
    <CustomPageTitle>Home</CustomPageTitle>
    <el-button>
      <NuxtLink to='/test'>Test</NuxtLink>
    </el-button>
    <p>is authed: {{ isAuthenticated }}</p>
    <p>user: {{ loggedInUser }}</p>
    <p>cookie: {{ $cookies.getAll() }}</p>

    <el-divider></el-divider>
    <el-button @click='getRoomList'>Get Room List</el-button>
    <el-button @click='cleanRoomList'>Clean Room List</el-button>
    {{ roomList }}
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'Home',
  data() {
    return {
      msg: 'Welcome to Your Vue.js App'
    };
  },

  computed: {
    langs() {
      return this.$i18n.locales.filter(i => i.code !== this.$i18n.locale);
    },
    ...mapGetters('room', ['roomList']),
    ...mapGetters(['isAuthenticated', 'loggedInUser']),
    ...mapGetters('locale', ['availableLocales'])
  },
  methods: {
    getRoomList() {
      this.$store.dispatch('room/fetchRoomList');
      console.log(this.roomList);
    },
    ...mapActions('room', ['cleanRoomList']),
    ...mapActions('locale', ['setLocale'])
  }

};
</script>

<style scoped lang='scss'>
</style>
