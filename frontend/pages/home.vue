<template>
  <div>
    <CustomPageTitle>Welcome, </CustomPageTitle>
    <el-card class="box-card">
    <img src='https://media-exp1.licdn.com/dms/image/C511BAQHPr7ah6EdDyA/company-background_10000/0/1547529153156?e=2159024400&v=beta&t=yyj6OBh7ormPeMsEEtbPRq2QY_JTy1aQPQeT5z9fhUg' class='image'>
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
    <div class='block'>
      <span class="demonstration">XMUM Campus</span>
      <el-carousel height="500px">
        <el-carousel-item v-for="item in images" :key="item">
          <h3 class="small">
            <img :src='item.url'/>
          </h3>
        </el-carousel-item>
      </el-carousel>
    </div>

  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'Home',
  data() {
    return {
      images:[{
        url: "https://www.easyuni.com/media/institution/photo/2017/09/05/xiamen_uni.jpg.600x400_q85.jpg",
      },
        {
        url: "http://www.xmu.edu.my/_upload/article/images/b2/50/83cf2af443298c30d4e6282b1247/e42a70fc-e2cb-41d7-87ff-1f5af26b8cd0.jpg",
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
.test {
  @apply md:bg-red-700;
}
.image {
  width: 100%;
  hight:30%;
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
