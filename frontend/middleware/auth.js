import Element from 'element-ui';

export default function ({ store, redirect, route }) {
  const path = route.path;
  const isLoggedIn = store.state.user;
  if (!isLoggedIn && path !== '/my/signin') {
    Element.Message.info('You need to Login first.');
    return redirect('/my/signin');
  }
  if (isLoggedIn && path === '/my/signin') {
    Element.Message.info('You are already logged in.');
    return redirect('/');
  }
}
