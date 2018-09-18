'use strict';

angular.module('myApp.home', ['ngRoute','firebase'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'views/home.html',
    controller: 'homeCtrl'
  });
}])

.controller('homeCtrl', ['$scope', '$http', '$location', '$rootScope', function($scope,$http,$location,$rootScope,$firebaseArray) {

	$scope.request = {};
	$scope.doSearch = function(request) {
		console.log($scope.request);

		$rootScope.age = $scope.request.age;
		$rootScope.income = $scope.request.income;
		$rootScope.profession = $scope.request.profession;
		$rootScope.gender = $scope.request.gender;

		$location.path('/delhiGov');
	}	
}]);