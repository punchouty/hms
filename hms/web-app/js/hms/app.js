'use strict';


// Declare app level module which depends on filters, and services
angular.module('hmsApp',  ['ngRoute', 'ngResource']).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {templateUrl: '/schedule', controller: 'hiringController'});
   $routeProvider.otherwise({redirectTo: '/view1'});
}]);
