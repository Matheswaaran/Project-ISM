'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.home',
  'myApp.delhiGov',
  'myApp.centralGov',
  'myApp.otherGov',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/home'});
}])

.run(function($rootScope){
	$rootScope.age;
	$rootScope.income;
	$rootScope.gender;
	$rootScope.profession;
});