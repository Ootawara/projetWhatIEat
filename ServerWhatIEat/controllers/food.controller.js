var Food= require('mongoose').model('Food');

function find(name, callback){
	Food.find({'name' : name}, function(err, food){
		if(err){
			callback(err, null);
		}else{
			if(food.length==0)
				callback(err, null);
			else
				callback(err, food);
		}
	});
};

function insert(food, callback){
	var food = new Food(food);
	food.save(function(err) {
		if(err){
			callback(err, "Insert failed");
		}else{
			callback(null, "Insert success");
		}
	});
};

function update(name, food, callback){
	Food.findOneAndUpdate({name : name}, food, function(err, food) {
		if(err){
			callback(err, "Update ailed")
		}else{
			callback(null, "Update success");
		}
	});
};

module.exports.getFood = function(req, res){

	find(req.params.name, function(err, result){
		if(!err){
			res.json(result);
		}else{
			res.json(err);
		}
	});
};

module.exports.insertFood = function(req, res){
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


module.exports.addComponents = function(req, res){
	find(req.body.name, function(err, result){
		Food.findOneAndUpdate({name : req.body.name}, { $push: {"isComposedBy": req.body.isComposedBy}}, function(err, food) {
				res.json(food);
		});
	});
};

module.exports.getAllFoods = function (req, res){
	Food.find({}, function(err, foods){
		if(err){
			res.json(err);
		}else{
			res.json(foods);
		}
	});
};