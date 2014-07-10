/**
 * Kamlesh mahawar
 */

hms.controller('assessmentRoundController', function($scope, $routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';
    $scope.scheduleRound_interviewId = $routeParams.interviewId;
	   
    hiringService.getPositions().$promise.then(function(positions){
		   $scope.assessments = positions;
		});
   
    hiringService.getRoundsByinterview(1,null ,null ,null ).$promise.then(function(positions){
    	
	      console.log(positions);
	});
	
});