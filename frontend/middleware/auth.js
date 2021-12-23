import Element from 'element-ui';

export default function({ store, redirect, route }) {
  if (route.path === '/my/signin') return;
  if (!store.state.user) {
    Element.Message.info('You need to login first.');
    return redirect('/my/signin');
  } else {
    return redirect('/my/reservation');
  }
}
