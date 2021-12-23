export default function({ store, redirect }) {
  if (!store.state.user) {
    return redirect('/my/signin');
  } else {
    return redirect('/my/reservation');
  }
}
