'use strict';

angular.module('myApp.otherGov', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/otherGov', {
    templateUrl: 'views/other_gov.html',
    controller: 'otherGovCtrl'
  });
}])

.controller('otherGovCtrl', [function() {

}]);