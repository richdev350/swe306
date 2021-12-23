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
  async login({ commit }, { username, password }) {
    // $post: get data of resp body
    // post: get resp body
    const resp = await this.$api.$post('/login', { username, password });
    if (resp.success) {
      const user = resp.content.user;
      const token = resp.content.token;
      commit('SET_USER', user);
      commit('SET_AUTH_TOKEN', token);
      this.$cookies.set('authToken', token);
      return resp;
    } else {
      console.log("failed ", resp);
    }
    // return this.$api.$post('/login', { username, password })
    //   .then((resp) => {
    //     console.log(resp);
    //     if (resp.success === false) {
    //       this.$message.error(resp.message);
    //     } else {
    //       const user = resp.content.user;
    //       const token = resp.content.token;
    //       commit('SET_USER', user);
    //       commit('SET_AUTH_TOKEN', token);
    //       this.$cookies.set('authToken', token);
    //     }
    //   });
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
