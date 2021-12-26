import Element from 'element-ui';

export default function ({ store, redirect, route }) {
  const path = route.path;
  const isLoggedIn = store.getters.isAuthenticated;
  const isAdmin = store.getters.isAdmin;

  if (!isLoggedIn && path !== '/my/signin') {
    Element.Message.info('You need to Login first.');
    return redirect('/my/signin');
  }
  if (isLoggedIn && path === '/my/signin') {
    Element.Message.info('You are already logged in.');
    return redirect('/');
  }
  if (!isAdmin) {
    Element.Message.info("You don't have access to this page.");
    return redirect('/');
  }
}
