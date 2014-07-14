hms.controller('hiringRoundController', function($scope, $routeParams, hiringService) {
	
	
	  $scope.name = 'hiringRoundController';
	  $scope.loggedInUser =  $('#loggedInUser').html();
	  $scope.loggedInUserId = $('#loggedInUserId').html();
	  
   //Schedule Rounds
	   $scope.scheduleRound_interviewId = $routeParams.interviewId;
	   hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function(assessmentRounds){
		   $scope.rounds = assessmentRounds;
		   $scope.rounds[0].interviewTime = "03/04/2014 13:00";
		  alert($scope.rounds[0].interviewTime);
//		   angular.forEach($scope.rounds, function(value, key){
//			   value.
//			   //alert(value.interviewTime)
//		   });
		});
	   
	   
	   $scope.scheduleInterview = function(roundId, interviewerId, interviewTime){
		 
		   hiringService.updateRound({"evaluationRoundId":roundId, "interviewerId":interviewerId, "interviewTime": document.getElementById("dt").value}).$promise.then(function(round){
		});
		   
	   }
	   
	   hiringService.getInterviewerDetails().$promise.then(function(interviewerDetails){
			  $scope.interviewers = interviewerDetails;
			  $scope.setInterviewer = function(site, round) {
				  round.interviewerId = site.id;
			  	};
			});
	 
	   $scope.meetsCriteria = function(round)
	   {
		   if (round.interviewerId && round.interviewTime)
			   return false
			   else return true
	   }
	  
	   $scope.changeInterviewer = function(round)
	   {
		   round.interviewerId = "";
	   }

});

