import Element from 'element-ui';

export default async function connectionTest({ app }) {
  const resp = await app.$api.$get('/connection');
  if (!resp.success) {
    await Element.MessageBox.confirm(
      'We could not connect to the server. Do you want to reload the page?',
      'Sorry',
      {
        type: 'warning',
      }
    )
      .then(() => {
        window.location.reload();
      })
      .catch(() => {
        Element.Message.error(
          'Please reload the page manually to get the latest data.'
        );
      });
  }
}
