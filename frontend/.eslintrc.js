module.exports = {
  root: true,
  env: {
    browser: true,
    node: true,
  },
  parserOptions: {
    parser: '@babel/eslint-parser',
    requireConfigFile: false,
  },
  extends: ['@nuxtjs', 'plugin:nuxt/recommended', 'prettier'],
  plugins: [],
  globals: {
    $nuxt: true,
    $api: true,
  },
  // add your custom rules here
  rules: {
    'no-console': 'warn',
    'vue/require-prop-types': 'off',
    'vue/component-definition-name-casing': 'off',
  },
};
