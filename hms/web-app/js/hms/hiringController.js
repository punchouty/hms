'use strict';

/* Controllers */

hms.controller('hiringController', function($scope,$routeParams, hiringService) {

	  $scope.name = 'hiringController';
	  
	  $scope.getPositions = function(){
	  hiringService.getPositions().$promise.then(function(positions){
			//$scope.interviews = data;
		});
	  }
	  
	  $scope.getHiringProcessesForPosition = function(positionId){
	  hiringService.getHiringProcessesForPosition(positionId).$promise.then(function(hiringProcesses){
			//$scope.interviews = data;
		});
	  }
	  
	  $scope.getAssessmentRoundsForProcess = function(processId){
	  hiringService.getAssessmentRoundsForProcess(processId).$promise.then(function(assessmentRounds){
			//$scope.interviews = data;
		});
	  }
	  
	  $scope.getCandidateDetails = function(nameSubStr){
	  hiringService.getCandidateDetails(nameSubStr).$promise.then(function(candidateDetails){
			//$scope.interviews = data;
		});
	  }
	  
	  $scope.getRoundSchedulesForInterview = function(interviewId){
	  hiringService.getRoundSchedulesForInterview(interviewId).$promise.then(function(roundSchedules){
			//$scope.interviews = data;
		});
	  }
	  
});

  
  
  
  
 
