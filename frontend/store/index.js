export const state = () => ({
  something: 1,
  isLogin: false,
});

export const mutations = {
  increment(state) {
    state.something += 1;
  },
};

export const actions = {
  logout({commit, app}){
    app.$cookies.remove('token');
  }
}
