/*
 * @author Mazi Muhlari
 * @see <a href="http://stackoverflow.com/questions/15332628/requirejs-domready-plugin-vs-jquery-document-ready">domReady!</a>
 */

require(['knockout', 'viewmodels/HomeViewModel', 'domReady!'], function(ko, HomeViewModel){
	ko.applyBindings(new HomeViewModel());
});