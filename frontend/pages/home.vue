<template>
  <div>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span style='font-size: 25px'>Welcom to XMUM Discussion Room Reservation System. </span>
      </div>
    <img src='https://pbs.twimg.com/media/E1_3TZxVEAYO-J6.jpg' class='card_image'>
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
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in images" :key="item">
        <h3 class="medium"> <img :src='item.url' class='image'/></h3>
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
      images:[{
        url: "https://media.istockphoto.com/photos/campus-of-xiamen-university-in-china-picture-id649983402?k=20&m=649983402&s=612x612&w=0&h=Lr-4XLanLIB64iSLYDH9nRIP-nqS9LZg-KjmjcHWmJM=",
      },
        {
        url: "http://p1.itc.cn/q_70/images03/20200926/ef3eacbc275f45aea9b08f9fa9f1c71b.jpeg",
      },
        {
          url: "https://easyuni.com/media/articles/2015/12/10/eca86bda385d172d5b6718.jpg",
        },
        {
          url: "http://www.xmu.edu.my/_upload/article/images/d1/f4/f536827945d8a2c71e9f4d887eaa/a0a5889f-c023-4b71-85a5-9a85168011cf.png",
        },
      ]
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
.box-card{
  margin-bottom: 5%;
  height:100%;
  width:100%;
}
.card_image{
  width:100%;
  height:100%;
}
.test {
  @apply md:bg-red-700;
}
.image {
  width: 100%;
  height: 100%;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
