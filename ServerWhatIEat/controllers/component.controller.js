var Component= require('mongoose').model('Component');

module.exports.getComponent = function(req, res){

};

module.exports.setComponent = function(req, res){
	var component = new Component(req.body);
	console.log(JSON.stringify(req.body));
	component.save(function(err) {
		if(err){	
			res.json(err);
		}else{
			res.json(component);
		}
	});
};

module.exports.getAllComponents = function (req, res){
	Component.find({}, function(err, components){
		if(err){
			res.json(err);
		}else{
			res.json(components);
		}
	});
};