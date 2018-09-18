'use strict';

angular.module('myApp.centralGov', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/centralGov', {
    templateUrl: 'views/central_gov.html',
    controller: 'centralGovCtrl'
  });
}])

.controller('centralGovCtrl', [function() {

}]);