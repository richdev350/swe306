export const state = () => ({
  authToken: false,
  user: null
});

export const mutations = {
  SET_AUTH_TOKEN(state, token) {
    state.authToken = token;
  },
  SET_USER(state, user) {
    state.user = user;
  }
};

export const actions = {
  // get auth token from local storage
  // FIXME
  nuxtServerInit({ commit }, { req }) {
    // if (req.session && req.session.authUser) {
    //   commit('SET_AUTHENTICATED', true);
    // }
  },
  logout({ commit }) {
    this.$cookies.remove('authToken');
    commit('SET_AUTH_TOKEN', null);
    commit('SET_USER', null);
  },
  login({ commit }, { username, password }) {
    // $post: get data of resp body
    // post: get resp body
    return this.$api.$post('/login', { username, password })
      .then((resp) => {
        console.log(resp);
        commit('SET_USER', { user: resp.user, role: resp.user.role });
        commit('SET_AUTH_TOKEN', resp.token);
        this.$cookies.set('authToken', resp.token);
      });
  }
};

export const getters = {
  isAuthenticated(state) {
    return state.authToken !== false;
  },
  loggedInUser(state) {
    return state.user;
  }
};
