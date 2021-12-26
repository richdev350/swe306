<template>
  <div>

    <CustomPageTitle align='center'>
      Welcom to XMUM Discussion Room Reservation System
    </CustomPageTitle>
    <el-card class='box-card'>
<!--      <div slot='header' class='clearfix'>-->
      <!--        <span style='font-size: 25px'> </span>-->
      <!--      </div>-->
      <img src='~/assets/images/xmum.jpeg' class='card_image'>
      <!--    <div class='test'>SomeText</div>
          <el-button>
            <NuxtLink to='/test'>Test</NuxtLink>
          </el-button>
          <p>is authed: {{ isAuthenticated }}</p>
          <p>user: {{ loggedInUser }}</p>
          <p>cookie: {{ $cookies.getAll() }}</p>

          <el-divider></el-divider>
          <el-button @click='getRoomList'>Get Room List</el-button>
          <el-button @click='cleanRoomList'>Clean Room List</el-button>
          {{ roomList }}-->
    </el-card>
    <el-divider content-position='center'>Campus Landscape</el-divider>
    <el-carousel :interval='4000' type='card' height='300px'>
      <el-carousel-item v-for='item in images' :key='item.id'>
        <h3 class='medium'><img :src='require(`~/assets/images/${item.url}`)' class='image' alt='item.desc' /></h3>
      </el-carousel-item>
    </el-carousel>


  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'Home',
  data() {
    return {
      images: [
        {
          id: 1,
          url: '1.jpeg',
          desc: ''
        },
        {
          id:2,
          url: '2.jpeg',
          desc: ''
        },
        {
          id  :3,
          url: '3.jpeg',
          desc: ''
        },
        {
          id:4,
          url: '4.png',
          desc: ''
        }
      ]
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
.box-card {
  margin-bottom: 5%;
  height: 100%;
  width: 100%;
}

.card_image {
  width: 100%;
  height: 100%;
}

.test {
  @apply md:bg-red-700;
}

.image {
  width: 100%;
  height: 100%;
  background-repeat: repeat;
}

.el-carousel__item h3 {

  font-size: 14px;
  opacity: 0.9;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {

}

.el-carousel__item:nth-child(2n+1) {

}
</style>
