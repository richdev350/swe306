<template>
  <div>
    <h3>XMUM Room Reservation</h3>
    <Room v-for="room in rooms" :id="room.id"
    :key="room.id"  :room="room.rooms" />
  </div>
</template>

<script>

import axios from '../../plugins/axios';
import Room from './roomDisplay';

export default {
  components:{
    Room
  },
  data(){
    return{
      rooms:{
        roomNo: '111',
        location: 'xmum',
      }
    };
  },
  head(){
    return{
      title:"XMUM Room Reservation",
      meta:[
        {
          hid: "description",
          name:"description",
          content:"Available rooms for reservation",
        }
      ]
    }
  },
  async created() {
    const config = {
      headers:{
        Accept:'?'
      }
    };
    try{
      const res = await axios.get('?', config);

      this.rooms = res.data.results;
    }catch (e) {
      console.log(e)
    }
  },
}
</script>

<style scoped lang='sass'>

</style>
