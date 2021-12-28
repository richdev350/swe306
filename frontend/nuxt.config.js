export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title:
      'Discussion Room Reservation System | Xiamen University Malaysia | SWE306 Final Project',
    htmlAttrs: {
      lang: 'en',
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1.0' },
      {
        hid: 'description',
        name: 'description',
        content:
          'Xiamen University Malaysia Discussion Room Reservation System | SWE306 Final Project',
      },
      { name: 'format-detection', content: 'telephone=no' },
    ],
    link: [{ rel: 'icon', type: 'images/x-icon', href: '/favicon.ico' }],
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: ['element-ui/lib/theme-chalk/index.css', 'assets/styles/global.scss'],

  // purge css except element-ui
  purgeCSS: {
    whitelistPatterns: [/el-.+$/],
    whitelistPatternsChildren: [/el-.+$/],
  },
  // vuex-persistedstate is not available on server side
  // TODO use local storage to persist login state
  ssr: false,
  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    '@/plugins/element-ui',
    '@/plugins/axios',
    '@/plugins/mock',
    '@/plugins/i18n',
    {
      src: '@/plugins/localStorage',
      ssr: false,
    },
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    '@nuxtjs/eslint-module',
    '@nuxtjs/tailwindcss',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    '@nuxtjs/axios',
    // FIXME deprecated auth module
    // '@nuxtjs/auth-next',
    'cookie-universal-nuxt',
    '@nuxtjs/proxy',
    '@nuxtjs/i18n',
  ],
  i18n: {
    langDir: '@/locales/',
    locales: [
      {
        code: 'en',
        iso: 'en-US',
        file: 'en-US.js',
      },
      {
        code: 'zh',
        iso: 'zh-CN',
        file: 'zh-CN.js',
      },
    ],
    defaultLocale: 'en',
    vueI18n: {
      fallbackLocale: 'en',
    },
  },
  // globally auth routing
  router: {
    middleware: ['connectionTest'],
  },
  axios: {
    // use $api
    baseURL: process.env.BASE_URL || 'http://localhost:3000',
  },
  proxy: {
    '/api': {
      target: 'http://111.229.100.125:8080/api',
      pathRewrite: {
        '^/api': '/',
      },
    },
  },
  env: {
    BASE_URL: process.env.BASE_URL,
    NODE_ENV: process.env.NODE_ENV,
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
    transpile: [/^element-ui/],
    loaders: {
      sass: {
        implementation: require('sass'),
      },
      scss: {
        implementation: require('sass'),
      },
    },
  },
};
