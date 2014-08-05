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
							alert();
							$scope.selectedCandidate = candidateDetails;
							$scope.selectedCandidateId = candidateDetails.id;
							$scope.addCandidateScreen = "";
						    $scope.newName = "";
							$scope.emailId = "";
							$scope.panNumber = "";
							$scope.contactNumber= "";
							$scope.passportNumber = "";
						});
						hiringService.getCandidateDetails().$promise
						.then(function(candidateDetails) {
							$scope.candidates = candidateDetails;
							$scope.selectedCandidate = '';
							$scope.setCandidate = function(site) {
								$scope.selectedCandidateId = site.id;
								$scope.newCandidate = "";
								$scope.isSetInterviewDisabled = false;
							};
						});
						
					}

					
				});
