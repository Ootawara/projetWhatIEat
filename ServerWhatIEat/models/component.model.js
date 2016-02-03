var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var componentSchema = new Schema({
	name : String,
	description : String,
	effects : String
	//IsInWhat : String???
});

mongoose.model('Component', componentSchema);