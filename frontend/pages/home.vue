<template>
  <div>
    <CustomPageTitle>Home</CustomPageTitle>
    <div class='test'>SomeText</div>
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
    ...mapGetters('room', ['roomList']),
    ...mapGetters(['isAuthenticated', 'loggedInUser'])
  },
  methods: {
    getRoomList() {
      this.$store.dispatch('room/fetchRoomList');
      console.log(this.roomList);
    },
    ...mapActions('room', ['cleanRoomList'])
  }

};
</script>

<style scoped lang='scss'>
.test {
  @apply md:bg-red-700;
}
</style>
