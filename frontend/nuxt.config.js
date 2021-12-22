export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'swe301-frontend',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=what' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [{ rel: 'icon', type: 'images/x-icon', href: '/favicon.ico' }]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
    'element-ui/lib/theme-chalk/index.css',
    'assets/styles/global.scss'
  ],

  // purge css except element-ui
  purgeCSS: {
    whitelistPatterns: [/el-.+$/],
    whitelistPatternsChildren: [/el-.+$/]
  },
  // vuex-persistedstate is not available on server side
  mode: 'spa',

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    '@/plugins/element-ui',
    '@/plugins/axios',
    '@/plugins/mock',
    {
      src: '@/plugins/localStorage', ssr: false
    }
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    '@nuxtjs/eslint-module',
    '@nuxtjs/tailwindcss'
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    '@nuxtjs/axios',
    // '@nuxtjs/auth-next',
    'cookie-universal-nuxt',
    '@nuxtjs/proxy'
  ],
  // globally auth routing
  // router:{
  //   middleware: ['auth']
  // },
  // auth: {
  //   strategies: {
  //     local: {
  //       token: {
  //         property: true,
  //         global: true
  //       },
  //       user: {
  //         property: 'user'
  //       },
  //       endpoints: {
  //         login: { url: '/api/auth/signin', method: 'post', propertyName: 'data.token' },
  //         logout: false,
  //         user: { url: '/api/auth/user', method: 'get', propertyName: 'data' }
  //       },
  //       redirect: {
  //         // TODO
  //         // login: '/signin',
  //         // logout: '/signin',
  //         // callback: '/signin',
  //         // home: '/'
  //       }
  //     }
  //   }
  // },
  axios: {
    // use $api
    baseURL: process.env.BASE_URL || 'http://localhost:3000'
  },
  proxy: {
    '/api': {
      target: 'http://localhost:8080/api',
      // target: 'https://mock.apipost.cn/app/mock/project/8df26568-96f2-4109-b993-3bb858931190',
      pathRewrite: {
        '^/api': '/'
      }
    }
  },
  env: {
    BASE_URL: process.env.BASE_URL,
    NODE_ENV: process.env.NODE_ENV
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
    transpile: [/^element-ui/],
    loaders: {
      sass: {
        implementation: require('sass')
      },
      scss: {
        implementation: require('sass')
      }
    }
  }
};
