'use strict';

angular.module('myApp.delhiGov', ['ngRoute','firebase'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/delhiGov', {
    templateUrl: 'views/delhi_gov.html',
    controller: 'delhiGovCtrl'
  });
}])

.controller('delhiGovCtrl', ['$scope', '$http', '$location', '$rootScope', '$firebaseArray', function($scope,$http,$location,$rootScope,$firebaseArray) {
	$scope.age = $rootScope.age
	$scope.income = $rootScope.income
	$scope.profession = $rootScope.profession
	$scope.gender = $rootScope.gender

	var maxAgeref = firebase.database().ref().orderByChild("max_age").equalTo($scope.age);
	$scope.maxAge = $firebaseArray(maxAgeref);

	var maxIncomeref = firebase.database().ref().orderByChild("max_income").equalTo($scope.income);
	$scope.maxIncome = $firebaseArray(maxIncomeref);

	var genref = firebase.database().ref().orderByChild("gender").equalTo($scope.gender);
	$scope.gen = $firebaseArray(genref);

	var profref = firebase.database().ref().orderByChild("profession").equalTo($scope.profession);
	$scope.prof = $firebaseArray(profref);


}]);