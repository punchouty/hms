
hms.controller('hiringRoundController', function($scope, $routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';
	  $scope.name = 'hiringRoundController';
	  
   //Schedule Rounds
	   $scope.scheduleRound_interviewId = $routeParams.interviewId;
	   hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function(assessmentRounds){
		   $scope.rounds = assessmentRounds;
		});
	 
	
});

  
  
  
  
 
