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
			  $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
			});
		  }
	  
	  
	 /*  hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function(interviews){
		     $scope.interviews = interviews; 
		});*/
	  
	   $scope.deleteInterview = function(id){
		   hiringService.deleteInterview(id).$promise.then(function(status){
			   $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
				
			});
	   }
	   
	   $scope.clearForm = function(){
		   $scope.msg = "";
		   $scope.isSetInterviewDisabled = true;
		   $scope.newCandidate="Yes"; 
	   }
	   $scope.filterOptions = {
		        filterText: "",
		        useExternalFilter: true
		    };
		    $scope.totalServerItems = 0;
		    $scope.pagingOptions = {
		        pageSizes: [5, 10, 20],
		        pageSize: 5,
		        currentPage: 1
		    };  
		    $scope.setPagingData = function(data, page, pageSize){	
		        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
		        $scope.myData = pagedData;
		        $scope.totalServerItems = data.length;
		        if (!$scope.$$phase) {
		            $scope.$apply();
		        }
		    };
		    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
		        setTimeout(function () {
		            var data;
		            if (searchText) {
		                var ft = searchText.toLowerCase();
		                hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function(interviews){
		                	data = interviews.filter(function(item) {
		                        return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
		                    });
			       		  $scope.setPagingData(data,page,pageSize);
			       		});
		                              
		            } else {
		            	hiringService.getInterviewsByUser($scope.loggedInUserId).$promise.then(function(interviews){
			       		  $scope.setPagingData(interviews,page,pageSize);
			       		});
		            }
		        }, 100);
		    };
			
		    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
			
		    $scope.$watch('pagingOptions', function (newVal, oldVal) {
		        if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
		          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
		        }
		    }, true);
		    $scope.$watch('filterOptions', function (newVal, oldVal) {
		        if (newVal !== oldVal) {
		          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
		        }
		    }, true);
	   
	   $scope.gridOptions = {
		        data: 'myData',
		        columnDefs: [{ field: "positionName", displayName: "Position",width: "12%" },
		                    { field: "hiringProcessName",displayName:"Hiring Process", width: "14%" },
		                    { field: "candidateName",displayName:"Candidate Name", width: "16%" },
		                    { field: "interviewMode  | renderMode",displayName:"Interview Mode", width: "14%" },
		                    { displayName:"Date Created",field: "dateCreated | date: 'dd-MM-yyyy HH:mma'" ,width: "14%" },
		                    { field: "completionStatus | renderStatus", displayName:"Completion Status ", width: "13%" },
		                    {displayName:"Actions",cellTemplate: '<a href="#/scheduleRounds/{{row.entity.interviewId}}" class="glyphicon glyphicon-time" title="Schedule round" style="margin-left:20%"></a><button ng-hide={{row.entity.completionStatus}} type="button" ng-click="deleteInterview(row.entity.interviewId)" class="close" style="color: red;margin-right: 20%" aria-hidden="true" title="Cancle Round">&times;</button>', width: "17%" }],
                enablePaging: true,
                showFilter: true,
        		showColumnMenu : true,
                showFooter: true,
                totalServerItems:'totalServerItems',
                pagingOptions: $scope.pagingOptions,
                filterOptions: $scope.filterOptions
		    };
	   
	  
});

  
  
  
  
 
