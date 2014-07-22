

'use strict';

/* Controllers */

hms.controller('hiringAssessRoundController', function($scope, hiringService) {
       
	$scope.loggedInUser =  $('#loggedInUser').html();
	$scope.loggedInUserId = $('#loggedInUserId').html();
       $scope.round = "domain";

                     
        /* hiringService.getScheduledRounds($scope.loggedInUserId).$promise.then(function(interviews){
             $scope.interviews = interviews;
          });*/
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
		                hiringService.getScheduledRounds($scope.loggedInUserId).$promise.then(function(interviews){
			       		     $scope.interviews = interviews;
			       		  $scope.setPagingData(interviews,page,pageSize);
			       		});
		                              
		            } else {
		            	hiringService.getScheduledRounds($scope.loggedInUserId).$promise.then(function(interviews){
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
 		        columnDefs: [{ field: "roundName",displayName:"Round Name" , width: "12%", pinned: true },
 		                    { field: "scheduledDate | date: 'dd-MM-yyyy HH:mma'",displayName:"Scheduled Date", width: "16%" },
 		                    { field: "candidateName",displayName:"Candidate Name", width: "15%" },
 		                    { field: "completionStatus | renderStatus",displayName:"Completion Status", width: "14%" },
 		                    { field: "hiringPersonName",displayName:"Hiring Person", width: "20%" },
 		                    {displayName:"Action",cellTemplate: '<a href="#/assessment/{{row.entity.evaluationRoundId}}" ng-click="updateStatusAsRechudule(interview.completionStatus)" class="glyphicon glyphicon-time" style="margin-left:20%" title="completion status"></a>', width: "23%" }],
 		                   showFilter: true,
   		       showColumnMenu : true,
   		       showFooter : true,
   		       showGroupPanel : true,
   		       pagingOptions: $scope.pagingOptions,
   		       enablePaging: true,
   		       totalServerItems:'totalServerItems',
   		       filterOptions: $scope.filterOptions
 		    };
//         $scope.updateStatusAsRechudule = function(status){
//                 hiringService.updateRoundStatus(status).$promise.then(function(){
//       
//                 hiringService.getRoundsByinterview($scope.loggedInUserId,$scope.selectedCandidate.id,$scope.selectedRoundId.id,$scope.selectedDate).$promise.then(function(interviewsByDetails)
//                       {
//                                     $scope.interviews = interviews;
//                                  });     
//                     });
//          }
//          $scope.updateStatusAsCancel = function(status){
//                 hiringService.updateRoundStatus(status).$promise.then(function(){
//       
//                 hiringService.getRoundsByinterview($scope.loggedInUserId,$scope.selectedCandidate.id,$scope.selectedRoundId.id,$scope.selectedDate).$promise.then(function(interviewsByDetails)
//                       {
//                                     $scope.interviews = interviews;
//                                  });     
//                     });
//          } 
//        
       });

  
  
  
  
 

