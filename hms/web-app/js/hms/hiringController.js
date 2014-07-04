'use strict';

/* Controllers */

hms.controller('hiringController', function($scope,$routeParams, hiringService) {
	
	$scope.loggedInUser = 'User';
	$scope.loggedInUserId = 1;
	$scope.newCandidate="Yes"; 
	$scope.isSetInterviewDisabled = true;

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
					  hiringService.getHiringProcessesForPosition($scope.selectedPositionId).$promise.then(function(hiringProcesses){
						  $scope.hiringProcesses = hiringProcesses;
						  $scope.selectedProcess = $scope.hiringProcesses[0]; 
						});
				
			  }
			 
			 $scope.loadHiringProcessesForPosition();
			 
	  })
	  
	  
	 
	 
	 
	  $scope.clearSelection = function(){
		  $scope.newCandidate="Yes";
		
	  }
	  
	  hiringService.getCandidateDetails().$promise.then(function(candidateDetails){
		  $scope.candidates = candidateDetails;
		  $scope.selectedCandidate = '';
		  $scope.setCandidate = function(site) {
		  		$scope.selectedCandidateId = site.id;
		  		$scope.newCandidate = "";
		  		$scope.isSetInterviewDisabled = false;
		  	};
		});
	  
   $scope.changeCandidate = function(){
	   $scope.selectedCandidateId = "";
	   $scope.newCandidate="Yes";
	   $scope.selectedCandidate = '';
	   $scope.isSetInterviewDisabled = true;
	   }
	  
	   $scope.addCandidate = function(){
		   hiringService.addCandidate({"name":"New Candidate", "location": "99128271122"}).$promise.then(function(candidateDetails){
			   $scope.selectedCandidate = candidateDetails;
			   $scope.selectedCandidateId = candidateDetails.id;
			   $scope.addCandidateScreen = "";
			});
	   }
	   
	  
	  
	  $scope.setInterview = function(){
		  $scope.interviewDetail = angular.fromJson({"candidateDetail":{"id":$scope.selectedCandidateId},"completionStatus":"0","hiringProcess":{"id":$scope.selectedProcess.id},"hiringperson":{"id":$scope.loggedInUserId},"interviewMode": $scope.selectedMode.code,"name":"Int1","position":{"id":$scope.selectedPosition.id}});
		  hiringService.createInterview($scope.interviewDetail).$promise.then(function(interviewDetails){
				 hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function(interviews){
					   $scope.interviews = interviews;
					});
				
			});
		  }
	  
	  
	   hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function(interviews){
		   $scope.interviews = interviews;
		});
	  
	   $scope.deleteInterview = function(id){
		   hiringService.deleteInterview(id).$promise.then(function(status){
				 hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function(interviews){
					   $scope.interviews = interviews;
					});
				
			});
	   }
	   
	   $scope.clearForm = function(){
		   $scope.msg = "";
		   $scope.isSetInterviewDisabled = true;
		   $scope.newCandidate="Yes"; 
	   }
	   
	
});

  
  
  
  
 
