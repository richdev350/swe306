export const state = () => ({
  roomList: [],
  myReservationList: [],
});

export const mutations = {
  setRoomList(state, roomList) {
    state.roomList = roomList;
  },
  setMyReservationList(state, reservationList) {
    // the latest reservation is the first one
    state.myReservationList = reservationList.reverse();
  },
};

export const actions = {
  // do not use this
  async fetchRoom({ commit }, roomId) {
    const resp = await this.$axios.$post('/getRoom', { roomId });
    if (resp.success) {
      return resp.content;
    } else {
      this.$message.error(resp.message);
      return null;
    }
  },

  async fetchRoomList({ commit }) {
    const resp = await this.$api.$get('/getRoomAll');
    const roomList = resp.content;
    if (resp.success && roomList.length > 0) {
      commit('setRoomList', roomList);
    } else {
      this.$message.error(resp.message);
    }
  },
  async fetchMyReservation({ commit, rootGetters }) {
    const resp = await this.$api.$post('/getReservation', {
      userId: rootGetters.loggedInUser.id,
    });
    const myReservationList = resp.content;
    if (resp.success && myReservationList.length > 0) {
      commit('setMyReservationList', myReservationList);
    } else {
      this.$message.error(resp.message);
    }
  },

  cleanRoomList({ commit }) {
    commit('setRoomList', []);
  },
  cleanMyReservationList({ commit }) {
    commit('setMyReservationList', []);
  },
};

export const getters = {
  roomList: (state) => state.roomList,
  myReservationList: (state) => state.myReservationList,
};
