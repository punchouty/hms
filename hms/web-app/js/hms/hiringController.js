'use strict';

/* Controllers */

hms.controller('hiringController', function($scope,$routeParams, hiringService) {

	  $scope.name = 'hiringController';
	  
	  hiringService.getPositions().$promise.then(function(positions){
		     $scope.positions = positions;
			 $scope.selectedPosition = $scope.positions[0]; 
			
			 hiringService.getHiringProcessesForPosition($scope.selectedPosition.id).$promise.then(function(hiringProcesses){
				  $scope.hiringProcesses = hiringProcesses;
				  $scope.selectedProcess = $scope.hiringProcesses[0]; 
				});
		});
	  

	 
	  $scope.selectedCandidate = '';
	  $scope.setCandidate = function(site) {
	  		$scope.selectedCandidateId = site.id;
	  	};
		
	  hiringService.getCandidateDetails().$promise.then(function(candidateDetails){
		  $scope.candidates = candidateDetails;
		});
	  
	  
	  $scope.getRoundSchedulesForInterview = function(interviewId){
	  hiringService.getRoundSchedulesForInterview(interviewId).$promise.then(function(roundSchedules){
			//$scope.interviews = data;
		});
	  }
	  
});

  
  
  
  
 
