'use strict';


// Declare app level module which depends on filters, and services
angular.module('hmsApp',  ['ngRoute', 'ngResource', 'ngSanitize', 'ngCookies']).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {templateUrl: '/view1', controller: 'hiringController'});
  $routeProvider.when('/view2', {templateUrl: '/view2', controller: 'hiringController'});
  $routeProvider.otherwise({redirectTo: '/view3'});
}]);
