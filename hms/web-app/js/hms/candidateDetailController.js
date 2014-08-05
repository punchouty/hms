'use strict';

/* Controllers */

hms
		.controller(
				'candidateDetailController',
				function($scope, $routeParams, hiringService) {
					$scope.mahawar ="kamlesh";
					$scope.loggedInUser = $('#loggedInUser').html();
					$scope.loggedInUserId = $('#loggedInUserId').html();

					$scope.addCandidate = function() {
						console.log('hello')
						hiringService.addCandidate({
							"name" : $scope.newName,
							"emailId" : $scope.emailId,
							"panNo" : $scope.panNumber,
							"contactNumber": $scope.contactNumber,
							"passportNumber": $scope.passportNumber,
							"dateCreated" : new Date()
						}).$promise.then(function(candidateDetails) {
						    $scope.newName = "";
							$scope.emailId = "";
							$scope.panNumber = "";
							$scope.contactNumber= "";
							$scope.passportNumber = "";
						});
						hiringService.getCandidateDetails().$promise
						.then(function(candidateDetails) {
							
						});
						
					}

					
				});
