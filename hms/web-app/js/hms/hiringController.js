'use strict';

/* Controllers */

'use strict';

/* Controllers */

angular.module('myApp.controllers', [])
  .controller('scheduleViewCtrl', ['$scope', function($scope,$routeParams,scheduledInterviews) {
  $scope.name = 'scheduleViewCtrl';
  scheduledInterviews.getInterviews().then(function(interviews) {
    $scope.interviews = interviews;
  });
 
  $scope.$on('handleScheduledInterviews', function(events, interviews) {
    $scope.interviews = interviews;
  });
  $scope.addCandidate = function() {
 ; }
  /* var interview= {
     position: $scope.position,
	 workflow: $scope.workflow,
	 round: $scope.round,
	 candidate: $scope.candidate,
	 interviewer: $scope.interviewer
	 };
    $scope.interviews.push(interview); */
  
  //  handling the submit button for the form
  $scope.schedule = function(interview) {
    $params = $.param({
     "position": interview.position,
	 "workflow": interview.workflow,
	 "round": interview.round,
	 "candidate": interview.candidate,
	 "interviewer": interview.interviewer,
	 "time":interview.time
    })
	scheduledInterviews.saveInterviews($params);
	}
  }])
  .controller('MyCtrl2', ['$scope', function($scope) {

  }])
  ;

  
  
  
  
 