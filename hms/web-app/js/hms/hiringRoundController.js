'use strict';

/* Controllers */

hms.controller('hiringRoundController', function($scope,$routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';

	  $scope.name = 'hiringRoundController';
	  
	   $scope.clearForm = function(){
		   $scope.msg = "";
	   }
	   
	   //Schedule Rounds
	   $scope.scheduleRound_interviewId = $routeParams.interviewId;
	  
	   hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function(interview){
		   $scope.interview = interview;
		   alert($scope.interview.id)
		});
	 
	
});

  
  
  
  
 
