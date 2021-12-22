export const state = () => ({
  // authToken: false
  // user: null // user object { username, role }
});

export const mutations = {
  // SET_AUTH_TOKEN(state, token) {
  //   state.authToken = token;
  // },
  // SET_USER(state, user) {
  //   state.user = user;
  // }
};

export const actions = {
  // what is this?
  // nuxtServerInit({ commit }, { req }) {
  //   if (req.session && req.session.authUser) {
  //     commit('SET_AUTHENTICATED', true);
  //   }
  // },
  logout({ commit, app }) {
    app.$cookies.remove('token');
  },
  // FIXME
  fakeLogin({ commit, app }) {
    commit('SET_USER', { username: 'admin', role: 'admin' });
    commit('SET_AUTH_TOKEN', 'fake-token');
    // app.$cookies.set('token', 'fake-token');
  },
  signin({ commit, app }, { username, password }) {
    return this.$api.$post('/api/signin', { username, password })
      .then(({ resp }) => {
        commit('SET_USER', { username: resp.data.username, role: resp.data.role });
        commit('SET_AUTH_TOKEN', resp.data.token);
        this.$cookies.set('token', resp.data.token);
      });
  }
};

export const getters = {
  isAuthenticated(state) {
    return state.auth.loggedIn;
  },
  loggedInUser(state) {
    return state.auth.user;
  }
};
