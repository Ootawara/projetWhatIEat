var config = require('./env/development');
var mongoose = require('mongoose');

module.exports = function() {
	var db = mongoose.connect(config.db);

	require('../models/component.model.js');
	require('../models/food.model.js');

	return db;
}
