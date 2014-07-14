
hms.controller('hiringRoundController', function($scope, $routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';
	  $scope.name = 'hiringRoundController';
	  
	  $scope.interviewerName="";
	  $scope.interviewTime="";
	 // $('input[type="datetime"]').setNow(true);
	  
   //Schedule Rounds
	   $scope.scheduleRound_interviewId = $routeParams.interviewId;
	   hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function(assessmentRounds){
		   $scope.rounds = assessmentRounds;
		});
	   
	   
	   $scope.scheduleInterview = function(roundId, interviewerId, interviewTime){
		 
		   hiringService.updateRound({"evaluationRoundId":roundId, "interviewerId":interviewerId, "interviewTime": document.getElementById("dt").value}).$promise.then(function(round){
		});
		   
	   }
	   
	   $scope.isScheduled = function(){
		  if ($scope.interviewerName=="")
			   return false;
			   else
			   return true;
	   }
	   
	   hiringService.getInterviewerDetails().$promise.then(function(interviewerDetails){
			  $scope.interviewers = interviewerDetails;
			  $scope.interviewerName = '';
			  $scope.setInterviewer = function(site, round) {
				  round.interviewerId = site.id;
			  	};
			});
	 
	
});

  
  
  
  
 
