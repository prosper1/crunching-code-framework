define(['knockout'], function(ko){
	return function HomeViewModel(){
		this.firstname = ko.observable('Mazi');
		this.firstnameCaps = ko.pureComputed(function(){
			return this.firstname().toUpperCase();
		}, this);
	}
})