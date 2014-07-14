/**
 * Kamlesh mahawar
 */

hms.controller('assessmentRoundController', function($scope, $routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';
	$scope.name = 'hiringRoundController';
    $scope.scheduleRound_evaluationRoundId =$routeParams.roundId;
	   hiringService.getAssessmentsForEvaluationRoundId($scope.scheduleRound_evaluationRoundId).$promise.then(function(assessmentRounds){
		   $scope.rounds = assessmentRounds;
		});
	   
  /*  hiringService.getPositions().$promise.then(function(positions){
		   $scope.assessments = positions;
		});
   
    hiringService.getRoundsByinterview(1,null ,null ,null ).$promise.then(function(positions){
    	
	      console.log(positions);
	});*/
	
});