hms.controller('assessmentRoundController', function($scope, $routeParams, hiringService) {

	  $scope.loggedInUser =  $('#loggedInUser').html();
	  $scope.loggedInUserId = $('#loggedInUserId').html();
	
	  $scope.scheduleRound_evaluationRoundId =$routeParams.roundId;
	 
	   hiringService.getEvaluationRound($scope.scheduleRound_evaluationRoundId).$promise.then(function(round){
		   $scope.round = round;
	   });
	   
	   $scope.updateskill = function(skillId,round){
		   hiringService.updateSkills({"evaluationSkillId":skillId, "candidateRating":parseInt(round.rating), "candidateScore": parseInt(round.candidateScore), "feedback":(round.feedback)})
		   .$promise.then(function(){
			   hiringService.getAssessmentsForEvaluationRoundId($scope.scheduleRound_evaluationRoundId).$promise.then(function(assessmentRounds){
				   $scope.rounds = assessmentRounds;
				});
		   });
	   }
		$scope.setSkillName = function(name, id) {
			$scope.skillName = name;
			$scope.evaluationSkillId = id;
		}
	  
  /*  hiringService.getPositions().$promise.then(function(positions){
		   $scope.assessments = positions;
		});
   
    hiringService.getRoundsByinterview(1,null ,null ,null ).$promise.then(function(positions){
    	
	      console.log(positions);
	});*/
	
});