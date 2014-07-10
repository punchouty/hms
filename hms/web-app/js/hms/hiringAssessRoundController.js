

'use strict';

/* Controllers */

hms.controller('hiringAssessRoundController', function($scope, hiringService) {
       
       $scope.loggedInUser = 'panelUser';
       $scope.loggedInUserId = 4;
       $scope.round = "domain";
//       $scope.interviews=[
//                            {roundName:'HR',scheduledDate : '01/01/2011',candidateName : 'priya',completionStatus : 'pending',hiringPersonName :'kamlesh'},
//                            {roundName:'asses',scheduledDate : '02/01/2011',candidateName : 'priya',completionStatus : 'pending',hiringPersonName :'kamlesh12'},
//                            {roundName:'comm',scheduledDate : '3-1-2011',candidateName : 'priya2',completionStatus : 'pending',hiringPersonName :'kamlesh23'},
//                            {roundName:'GD',scheduledDate : '4-1-2011',candidateName : 'priya3',completionStatus : 'pending',hiringPersonName :'kamlesh6'}
//                          ];
         
         $scope.searchInterviews = function(){
                hiringService.getRoundsByinterview($scope.loggedInUserId).$promise.then(function(interviews)
                       {
                                     $scope.interviews = interviews;
                                     console.log(interviews);
                                  });
                           
                     };
//                     
//         hiringService.getRoundsByinterview($scope.loggedInUserId,$scope.selectedCandidate,$scope.selectedRound,$scope.selectedDate).$promise.then(function(interviews)
//                       {
//                                     $scope.interviews = interviews;
//                                  });
//                                  
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

  
  
  
  
 

