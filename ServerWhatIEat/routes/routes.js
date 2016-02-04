var bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({ extended: false });

var component = require('../controllers/component.controller');

module.exports = function (app) {
	app.get('/component/', component.getAllComponents);
	app.get('/component/:name', component.getComponent);
	app.post('/component', urlencodedParser, component.insertComponent);

	app.use(function(req, res, next){
		res.setHeader('Content-Type', 'text/plain');
		res.status(404).send('Page not found');
	});
}
