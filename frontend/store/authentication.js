export const state = () => ({
  something: 1,
});

export const mutations = {
  increment(state) {
    state.something += 1;
  },
};
