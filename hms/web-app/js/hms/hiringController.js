'use strict';

/* Controllers */

hms.controller('hiringController', function($scope,$routeParams, hiringService) {
	
	$scope.loggedInUser =  $('#loggedInUser').html();
	$scope.loggedInUserId = $('#loggedInUserId').html();
		
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
	   $scope.isSetInterviewDisabled = true;
	   $scope.newCandidate="Yes";
	   }
	  
	   $scope.addCandidate = function(){
		   hiringService.addCandidate({"name":$scope.newName, "location": $scope.newInfo}).$promise.then(function(candidateDetails){
			   $scope.selectedCandidate = candidateDetails;
			   $scope.selectedCandidateId = candidateDetails.id;
			   $scope.addCandidateScreen = "";
			   $scope.newName = "";
			   $scope.newInfo = "";
			   $scope.isSetInterviewDisabled = false;
			});
		   hiringService.getCandidateDetails().$promise.then(function(candidateDetails){
				  $scope.candidates = candidateDetails;
				  $scope.selectedCandidate = '';
				  $scope.setCandidate = function(site) {
				  		$scope.selectedCandidateId = site.id;
				  		$scope.newCandidate = "";
				  		$scope.isSetInterviewDisabled = false;
				  	};
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
		   console.table(interviews)
		   
		});
	   $scope.gridOptions = {
		        data: 'interviews',
		        columnDefs: [{ field: "positionName", displayName: "Position",width: "12%", pinned: true },
		                    { field: "hiringProcessName",displayName:"Hiring Process", width: "16%" },
		                    { field: "candidateName",displayName:"Candidate Name", width: "15%" },
		                    { field: "interviewMode  | renderMode",displayName:"Interview Mode", width: "14%" },
		                    { displayName:"Date Created",field: "dateCreated | date: 'dd-MM-yyyy HH:mma'" ,width: "20%" },
		                    { field: "completionStatus | renderStatus", displayName:"Completion Status ", width: "12%" },
		                    {displayName:"    ",cellTemplate: '<a href="#/scheduleRounds/{{row.entity.interviewId}}" class="glyphicon glyphicon-time" style="margin-left:20%"></a><button ng-hide={{row.entity.completionStatus}} type="button" ng-click="deleteInterview(row.entity.interviewId)" class="close" style="color: red" aria-hidden="true">&times;</button>', width: "12%" }],
		       showFilter: true,
		       showColumnMenu : true,
		       showFooter : true,
		       showGroupPanel : true
		    };
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

  
  
  
  
 
