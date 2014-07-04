'use strict';


// Declare app level module which depends on filters, and services
var hms = angular.module('hmsApp',  ['ngRoute', 'ngResource', 'ui.bootstrap']);

hms.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/schedule', {templateUrl: 'schedule', controller: 'hiringController'});
  $routeProvider.when('/scheduleRounds/:interviewId', {templateUrl: 'scheduleRounds', controller: 'hiringRoundController'});
  $routeProvider.when('/assessment', {templateUrl: 'assessment', controller: 'hiringController'});
  $routeProvider.when('/configureWF', {templateUrl: 'configureWF', controller: 'hiringController'});
  $routeProvider.when('/createWF', {templateUrl: 'createWF', controller: 'hiringController'});
   $routeProvider.otherwise({redirectTo: 'schedule'});
}]);
