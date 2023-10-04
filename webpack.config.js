const path = require('path');

module.exports = {
  entry: './src/main/resources/static/js/store.js', // Đường dẫn đến tệp JavaScript của bạn
  output: {
    path: path.resolve(__dirname, 'src/main/resources/static/build'), // Thư mục đầu ra
    filename: 'store.bundle.js', // Tên tệp đầu ra
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
        },
      },
    ],
  },
  resolve: {
    extensions: ['.js', '.jsx'],
  },
};
