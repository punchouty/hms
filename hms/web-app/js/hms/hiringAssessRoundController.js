

'use strict';

/* Controllers */

hms.controller('hiringAssessRoundController', function($scope, hiringService) {
       
	$scope.loggedInUser =  $('#loggedInUser').html();
	$scope.loggedInUserId = $('#loggedInUserId').html();
       $scope.round = "domain";

                     
         hiringService.getScheduledRounds($scope.loggedInUserId).$promise.then(function(interviews){
             $scope.interviews = interviews;
             console.dir(interviews);
          });
              
         $scope.gridOptions = {
 		        data: 'interviews',
 		        columnDefs: [{ field: "roundName", width: "12%", pinned: true },
 		                    { field: "scheduledDate", width: "16%" },
 		                    { field: "candidateName", width: "15%" },
 		                    { field: "completionStatus", width: "14%" },
 		                    { field: "hiringPersonName", width: "20%" },
 		                    {displayName:"    ",cellTemplate: '<a href="#/assessment/{{row.entity.evaluationRoundId}}" ng-click="updateStatusAsRechudule(interview.completionStatus)" class="glyphicon glyphicon-time" title="completion status"></a>', width: "12%" }],
 		       showFilter: true,
 		       showColumnMenu : true,
 		       showFooter : true,
 		       showGroupPanel : true
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

  
  
  
  
 

