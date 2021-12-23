export const state = () => ({
  roomList: [],
});

export const mutations = {
  setRoomList(state, roomList) {
    state.roomList = roomList;
  },
};

export const actions = {
  async fetchRoomList({ commit }) {
    const resp = await this.$api.$get('/getRoomAll');
    const roomList = resp.content;
    if (resp.success && roomList.length > 0) {
      commit('setRoomList', roomList);
    }
  },
  cleanRoomList({ commit }) {
    commit('setRoomList', []);
  },
};

export const getters = {
  roomList: (state) => state.roomList,
};
