const path = require("path");
const HtmlWebPackPlugin = require("html-webpack-plugin");

module.exports = {
    mode: "none",
    entry: "./src/index.js",
    devtool: "source-map",
    output: {
        path: path.resolve(__dirname, "dist"),
        filename: "bundler.js"
    },
    module: {
        rules: [{
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            use: {
                // carregar arquivos js / jsx para que eles sejam
                // transpilados pelo babel para diferentes versoes do ecmascript
                loader: "babel-loader"
            }
        }]
    },
    plugins: [
        new HtmlWebPackPlugin({
            template: "./src/index.html",
            filename: "./index.html"
        })
    ]
}