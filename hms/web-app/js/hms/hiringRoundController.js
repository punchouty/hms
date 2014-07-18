hms.controller('hiringRoundController', function($scope, $routeParams, hiringService) {
	
	
	  $scope.name = 'hiringRoundController';
	  $scope.loggedInUser =  $('#loggedInUser').html();
	  $scope.loggedInUserId = $('#loggedInUserId').html();
	  
   //Schedule Rounds
	   $scope.scheduleRound_interviewId = $routeParams.interviewId;
	   hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function(assessmentRounds){
		   $scope.rounds = assessmentRounds;
		});
	   
	   
	   $scope.scheduleInterview = function(roundId, interviewerId, round){
		 console.log(round.interviewTime);
		   hiringService.updateRound({"evaluationRoundId":roundId, "interviewerId":interviewerId, "interviewTime": round.interviewTime}).$promise.then(function(round){
		});
		   
	   }
	   
	   $scope.isScheduled = function(round){
//		  if (round.interviewerName=="")
//			   return false;
//			   else
//			   return true;
	   }

	   
	   hiringService.getInterviewerDetails().$promise.then(function(interviewerDetails){
			  $scope.interviewers = interviewerDetails;
			  $scope.setInterviewer = function(site, round) {
				  round.interviewerId = site.id;
			  	};
			});
	 
	
});

