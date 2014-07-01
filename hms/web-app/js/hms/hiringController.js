'use strict';

/* Controllers */

hms.controller('hiringController', function($scope,$routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';

	  $scope.name = 'hiringController';
	  
	  hiringService.getPositions().$promise.then(function(positions){
		     $scope.positions = positions;
			 $scope.selectedPosition = $scope.positions[0]; 
			
			 hiringService.getHiringProcessesForPosition($scope.selectedPosition.id).$promise.then(function(hiringProcesses){
				  $scope.hiringProcesses = hiringProcesses;
				  $scope.selectedProcess = $scope.hiringProcesses[0]; 
				});
		});
	  
	  hiringService.getCandidateDetails().$promise.then(function(candidateDetails){
		  $scope.candidates = candidateDetails;
		  $scope.selectedCandidate = '';
		  $scope.setCandidate = function(site) {
		  		$scope.selectedCandidateId = site.id;
		  	};
		});
	  
	  
	  
	  $scope.setInterview = function(){
		  $scope.interviewDetail = angular.fromJson({"candidate":{"id":$scope.selectedCandidateId},"completionStatus":"0","hiringProcess":{"id":$scope.selectedProcess.id},"hiringperson":{"id":1},"interviewMode":"T","name":"Int1","position":{"id":$scope.selectedPosition.id},"results":[]});
		  hiringService.createInterview($scope.interviewDetail).$promise.then(function(interviewDetails){
				$scope.msg = "Success!";
				 hiringService.getInterviews($scope.loggedInUser).$promise.then(function(interviews){
					   $scope.interviews = interviews;
					});
				
			});
		  }
	  
	  
	   hiringService.getInterviews($scope.loggedInUser).$promise.then(function(interviews){
		   $scope.interviews = interviews;
		});
	  
	   $scope.deleteInterview = function(id){
		   hiringService.deleteInterview(id).$promise.then(function(status){
			   $scope.msg = "Success!";
				 hiringService.getInterviews($scope.loggedInUser).$promise.then(function(interviews){
					   $scope.interviews = interviews;
					});
				
			});
	   }
	   
	   $scope.clearForm = function(){
		   $scope.msg = "";
	   }
	   
	  
});

  
  
  
  
 
