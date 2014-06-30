'use strict';


// Declare app level module which depends on filters, and services
var hms = angular.module('hmsApp',  ['ngRoute', 'ngResource']);

hms.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {templateUrl: '/schedule', controller: 'hiringController'});
   $routeProvider.otherwise({redirectTo: '/view1'});
}]);
