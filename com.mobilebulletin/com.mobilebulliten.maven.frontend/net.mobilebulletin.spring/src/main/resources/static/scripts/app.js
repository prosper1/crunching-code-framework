requirejs.config({
	baseUrl: 'vendors',
	paths: {
		
		jquery: '',
		knockout: 'knockout-3.3.0',
		sammy: '',
		
		viewmodels: '../viewmodels'
	}
});

requirejs([], function(){
	
});