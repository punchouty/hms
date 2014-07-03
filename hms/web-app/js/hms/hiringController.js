'use strict';

/* Controllers */

hms.controller('hiringController', function($scope,$routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';

	  $scope.name = 'hiringController';
	  
	  $scope.modes = [{"name": "Telephonic", "code": "T"}, {"name": "Face-To-Face", "code": "F"}];
	  $scope.selectedMode = $scope.modes[0]; 
	  $scope.positions ={};
	  
	  
	  hiringService.getPositions().$promise.then(function(positions){
		     $scope.positions = positions;
			 $scope.selectedPosition = $scope.positions[0]; 
			 $scope.selectedPositionId = $scope.positions[0].id; 
			 
			 
			 
			 $scope.loadHiringProcessesForPosition = function () {
				
				 $scope.selectedPositionId = $scope.selectedPosition.id 
				 
				  alert($scope.selectedPositionId);
					  hiringService.getHiringProcessesForPosition($scope.selectedPositionId).$promise.then(function(hiringProcesses){
						  $scope.hiringProcesses = hiringProcesses;
						  $scope.selectedProcess = $scope.hiringProcesses[0]; 
						});
				
			  }
			 
			 $scope.loadHiringProcessesForPosition();
			 
	  })
	  
	  
	 
	  
	 
	  
	  hiringService.getCandidateDetails().$promise.then(function(candidateDetails){
		  $scope.candidates = candidateDetails;
		  $scope.selectedCandidate = '';
		  $scope.setCandidate = function(site) {
		  		$scope.selectedCandidateId = site.id;
		  	};
		});
	  
	   $scope.addCandidate = function(){
		   $scope.candidateDetail = angular.fromJson({"location":'GGN',"name":$scope.selectedCandidate.name});
		   hiringService.addCandidate( $scope.selectedCandidate).$promise.then(function(candidateDetails){
			   $scope.selectedCandidate = candidateDetails;
			   $scope.selectedCandidateId = candidateDetails.id;
			   
			});
	   }
	   
	  
	  
	  $scope.setInterview = function(){
		  $scope.interviewDetail = angular.fromJson({"candidateDetail":{"id":$scope.selectedCandidateId},"completionStatus":"0","hiringProcess":{"id":$scope.selectedProcess.id},"hiringperson":{"id":1},"interviewMode": $scope.selectedMode.code,"name":"Int1","position":{"id":$scope.selectedPosition.id}});
		  hiringService.createInterview($scope.interviewDetail).$promise.then(function(interviewDetails){
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
				 hiringService.getInterviews($scope.loggedInUser).$promise.then(function(interviews){
					   $scope.interviews = interviews;
					});
				
			});
	   }
	   
	   $scope.clearForm = function(){
		   $scope.msg = "";
	   }
	   
	
	   
	  
});

  
  
  
  
 
