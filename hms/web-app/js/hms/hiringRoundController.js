
hms.controller('hiringRoundController', function($scope, $routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';
	  $scope.name = 'hiringRoundController';
	  
	  $scope.interviewerName="";
	  
   //Schedule Rounds
	   $scope.scheduleRound_interviewId = $routeParams.interviewId;
	   hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function(assessmentRounds){
		   $scope.rounds = assessmentRounds;
		});
	   
	   
	   $scope.scheduleInterview = function(roundId, interviewerId){
		   hiringService.updateRound({"evaluationRoundId":roundId, "interviewerId":interviewerId, "interviewTime": $scope.interviewTime}).$promise.then(function(round){
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
			  $scope.selectedInterviewer = '';
			  $scope.setInterviewer = function(site) {
			  		$scope.selectedInterviewerId = site.id;
			  	};
			});
	 
	
});

  
  
  
  
 
