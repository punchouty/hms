

'use strict';

/* Controllers */

hms.controller('hiringAssessRoundController', function($scope, hiringService) {
       
       $scope.loggedInUser = 'panelUser';
       $scope.loggedInUserId = 4;
       $scope.round = "domain";

                     
         hiringService.getAssessRoundListForInterview(9).$promise.then(function(interviews){
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

  
  
  
  
 

