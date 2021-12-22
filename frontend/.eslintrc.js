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
  // add your custom rules here
  rules: {
    // TODO temporary supress warning
    // 'no-console': 'warn',
    'no-console': 'off',
    'vue/require-prop-types': 'off',
    'vue/component-definition-name-casing': 'off'
  },
};
