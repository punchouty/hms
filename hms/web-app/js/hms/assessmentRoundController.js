hms.controller('assessmentRoundController', function($scope, $routeParams, hiringService, $timeout) {

	  $scope.loggedInUser =  $('#loggedInUser').html();
	  $scope.loggedInUserId = $('#loggedInUserId').html();
	  $scope.isDisabled =true;
	  $scope.scheduleRound_evaluationRoundId =$routeParams.roundId;
	  $scope.candidateId =$routeParams.candidateId;
	  $scope.candidateName =$routeParams.candidateName;
	   hiringService.getEvaluationRound($scope.scheduleRound_evaluationRoundId).$promise.then(function(round){
		   $scope.round = round;
	   });
	   
	   $scope.updateScore = function(round){
		   $scope.skill.candidateScore = parseInt($scope.skill.weight) * parseInt($scope.skill.candidateRating);
		   $scope.bucket.candidateBucketScore = 0;
		   round.candidateRoundScore = 0;
		   angular.forEach($scope.bucket.skillEval, function(value, key){
			   $scope.bucket.candidateBucketScore = $scope.bucket.candidateBucketScore+ parseInt(value.candidateScore);		   
		   });
		   angular.forEach(round.bucketEval, function(value, key){
			   round.candidateRoundScore = round.candidateRoundScore + parseInt(value.candidateBucketScore);	
		   });
		   hiringService.updateRound(round)
		   .$promise.then(function(){
			   hiringService.getEvaluationRound($scope.scheduleRound_evaluationRoundId)
				   .$promise.then(function(assessmentRounds){
					   $scope.round = assessmentRounds;
					   $scope.skill = "";
						$scope.bucket = "";
						$scope.toggle = false;
						$scope.message = "Successfully";
						$scope.class = "success";
						$scope.isCompleted = true;
						 $timeout(function(){
			                	$scope.isCompleted = false;
			        		},2000);
					});
		   });
	   }
	   
		$scope.setSkillName = function(skill, bucket) {
			$scope.toggle = true;
			$scope.skill = skill;
			$scope.bucket = bucket;	
			$scope.isDisabled =true;
			$scope.isShowForm = true;
		}

		$scope.updateStatus = function(round, status) {
			if (hiringService.validateStatusChange(
					round.assessmentStatus, status)) {
				round.assessmentStatus = status;
				hiringService.updateRound2(round).$promise
						.then(function() {
							$scope.message = "Successfully";
							$scope.class = "success";
							$scope.isCompleted = true;
							$scope.statusTo ="";
							$scope.center = " ";
							$scope.status = "";
							 $timeout(function(){
				                	$scope.isCompleted = false;
				        		},2000);
						});
			} else {
				$scope.message = " failed as not allowed to move from ";
				$scope.statusTo = round.assessmentStatus;
				$scope.center = " to ";
				$scope.status = status;
				$scope.class = "error";
				$scope.isCompleted = true;
				 $timeout(function(){
	                	$scope.isCompleted = false;
	        		},2000);
			}
		}
		
		$scope.enableButton = function() {
			$scope.isDisabled =false;
		}	
});