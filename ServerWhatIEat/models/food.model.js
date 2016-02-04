var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var foodSchema = new Schema({
	name : String,
	description : String,
	effects : String,
	isComposedBy : [String]
});

mongoose.model('Food', foodSchema);
