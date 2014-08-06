'use strict';

// Declare app level module which depends on filters, and services
var hms = angular.module('hmsApp',  ['ngRoute', 'ngResource', 'ui.bootstrap','ngGrid','ui.bootstrap.datetimepicker']);

hms.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/candidateDetail', {templateUrl: 'candidateDetail', controller: 'candidateDetailController'});
	  $routeProvider.when('/schedule/:candidateId/:candidateName', {templateUrl: 'schedule', controller: 'hiringController'});
	  $routeProvider.when('/scheduleRounds/:interviewId/:candidateId/:candidateName', {templateUrl: 'scheduleRounds', controller: 'hiringRoundController'});
	  $routeProvider.when('/assessmentRoundsList', {templateUrl: 'assessmentRoundsList', controller: 'hiringAssessRoundController'});
	  $routeProvider.when('/assessment/:roundId', {templateUrl: 'assessment', controller: 'assessmentRoundController'});
	  $routeProvider.when('/configureWF', {templateUrl: 'configureWF', controller: 'hiringController'});
	  $routeProvider.when('/createWF', {templateUrl: 'createWF', controller: 'hiringController'});
	  $routeProvider.when('/dashboard', {templateUrl: 'dashboard', controller: 'hiringController'});
	  $routeProvider.otherwise({redirectTo: 'dashboard'});
}]);
