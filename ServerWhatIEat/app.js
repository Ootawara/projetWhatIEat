process.env.NODE_ENV = process.env.NODE_ENV || 'development';

var express = require('./config/express.js');
var mongoose = require('./config/mongoose.js');

var db = mongoose();
var app = express();

var port = 8000;

app.listen(port);
console.log('Server listen on : ' + port);


