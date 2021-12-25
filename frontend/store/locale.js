export const state = () => ({
  lang: 'zh',
});

export const mutations = {
  SET_LANG(state, langCode) {
    state.lang = langCode;
    this.$i18n.setLocale(langCode);
    this.$cookies.set('lang', langCode);
  },
};

export const actions = {
  nuxtServerInit({ commit }, { req }) {
    if (req.headers.cookie) {
      const lang = req.headers.cookie
        .split(';')
        .find((c) => c.trim().startsWith('lang='))
        .trim()
        .split('=')[1];
      commit('SET_LANG', lang);
    }
  },
  setLocale({ commit }, langCode) {
    commit('SET_LANG', langCode);
  },
};

export const getters = {
  currentLocale(state) {
    return state.lang;
  },
  availableLocales(state) {
    // TODO import i18n module to use
    // return IVueI18nNuxt.locales.filter((i) => i.code !== IVueI18nNuxt.locale);
  },
};
