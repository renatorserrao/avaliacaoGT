const proxy = [
    {
      context: '/api',
      target: 'http://avaliacao.jelastic.saveincloud.net/',
      pathRewrite: {'^/api' : ''}
    }
  ];
  module.exports = proxy;