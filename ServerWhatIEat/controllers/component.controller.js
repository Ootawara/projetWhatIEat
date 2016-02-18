var Component= require('mongoose').model('Component');

function find(name, callback){
	Component.find({'name' : name}, function(err, component){
		if(err){
			callback(err, null);
		}else{
			if(component.length==0)
				callback(err, null);
			else{
				callback(err, component);
			}
		}
	});
};

function insert(component, callback){
	var component = new Component(component);
	component.save(function(err) {
		if(err){
			callback(err, "Insert failed");
		}else{
			callback(null, "Insert success");
		}
	});
};

function update(name, component, callback){
	Component.findOneAndUpdate({name : name}, component, function(err, component) {
		if(err){
			callback(err, "Update ailed")
		}else{
			callback(null, "Update success");
		}
	});
};

module.exports.getComponent = function(req, res){

	find(req.params.name, function(err, result){
		if(!err){
			res.json(result);
		}else{
			res.json(err);
		}
	});
};

module.exports.insertComponent = function(req, res){
	find(req.body.name, function(err, result){
		if(result){
			update(req.body.name, req.body, function(err, result){
				if(err){
					res.json(err);
				}else{
					res.json(result);
				}
			});
		}else{
			insert(req.body, function(err, result){
				if(err){
					res.json(err);
				}else{
					res.json(result);
				}
			});
		}
	});
};

module.exports.addFoods = function(req, res){
	find(req.body.name, function(err, result){
		var list = req.body.isInWhat.split(",");
		Component.findOneAndUpdate({name : req.body.name}, {"isInWhat": list}, function(err, component) {
				res.json(component);
		});
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
