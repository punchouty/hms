

'use strict';

/* Controllers */

hms.controller('hiringAssessRoundController', function($scope, hiringService) {
       
	$scope.loggedInUser =  $('#loggedInUser').html();
	$scope.loggedInUserId = $('#loggedInUserId').html();
       $scope.round = "domain";

                     
         hiringService.getScheduledRounds($scope.loggedInUserId).$promise.then(function(interviews){
             $scope.interviews = interviews;
          });
                                  
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

  
  
  
  
 

