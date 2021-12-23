import createPersistedState from 'vuex-persistedstate'

// TODO: use local storage to persist state
export default ({store}) => {
  createPersistedState({
    key: 'nuxt',
    // paths: ["auth"] FIXME
  })(store)
}
