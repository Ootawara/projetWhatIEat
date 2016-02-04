var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({ extended: false });

var component = require('../controllers/component.controller');
var food = require('../controllers/food.controller');

module.exports = function (app) {
	//component API
	app.get('/component/', component.getAllComponents);
	app.get('/component/:name', component.getComponent);
	app.post('/component', urlencodedParser, component.insertComponent);
	app.post('/component/food', urlencodedParser, component.addFoods);
	//food api
	app.get('/food/', food.getAllFoods);
	app.get('/food/:name', food.getFood);
	app.post('/food', urlencodedParser, food.insertFood);
	app.post('/food/component', urlencodedParser, food.addComponents);

	app.use(function(req, res, next){
		res.setHeader('Content-Type', 'text/plain');
		res.status(404).send('Page not found');
	});
}
