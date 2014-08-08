'use strict';

/* Controllers */

hms
		.controller(
				'candidateDetailController',
				function($scope, $routeParams, hiringService, $rootScope) {
					$scope.loggedInUser = $('#loggedInUser').html();
					$scope.loggedInUserId = $('#loggedInUserId').html();
					$scope.showMessage = false;
					$scope.candidateDetails = "";
					$scope.modal = {};
					$scope.candidateDetails = {};
					$scope.addCandidate = function() {
						hiringService.addCandidate({
							"name" : $scope.newName,
							"emailId" : $scope.emailId,
							"panNo" : $scope.panNumber,
							"contactNumber" : $scope.contactNumber,
							"passportNumber" : $scope.passportNumber,
							"dateCreated" : new Date()
						}).$promise.then(function(response) {

							if (response.error) {
								$scope.showMessage = true;
							} else {
								$scope.candidateDetails = [ response ];
							}
							$scope.newName = "";
							$scope.emailId = "";
							$scope.panNumber = "";
							$scope.contactNumber = "";
							$scope.passportNumber = "";
						});
					}

					$scope.searchCandidate = function() {
						hiringService.searchCandidate({
							"name" : $scope.newName,
							"emailId" : $scope.emailId,
							"panNo" : $scope.panNumber,
							"contactNumber" : $scope.contactNumber,
							"passportNumber" : $scope.passportNumber,
							"dateCreated" : new Date()
						}).$promise.then(function(candidateDetails) {
							$scope.candidateDetails = candidateDetails;
							$scope.newName = "";
							$scope.emailId = "";
							$scope.panNumber = "";
							$scope.contactNumber = "";
							$scope.passportNumber = "";
						});
					}

					$scope.clearForm = function() {
						$scope.newName = "";
						$scope.emailId = "";
						$scope.panNumber = "";
						$scope.contactNumber = "";
						$scope.passportNumber = "";
					}

					$scope.updateModalDetails = function(details) {
						$scope.modal.modalNewName = details.name;
						$scope.modal.modalPanNumber = details.panNo;
						$scope.modal.modalEmailId = details.emailId;
						$scope.modal.modalContactNumber = details.contactNumber;
						$scope.modal.modalPassportNumber = details.passportNumber;
						$scope.modal.modalCandidateId = details.id;
					}

					$scope.updateCandidateDetails = function(modal) {
						var data = {
							'name' : modal.modalNewName,
							'panNo' : modal.modalPanNumber,
							'emailId' : modal.modalEmailId,
							'contactNumber' : modal.modalContactNumber,
							'passportNumber' : modal.modalPassportNumber,
							'id' : modal.modalCandidateId
						};
						console.log(data);

						hiringService.updateCandidateDetails(data).$promise
								.then(function(response) {
									$scope.candidateDetails = [ response ];
								})

					}

					$scope.gridOptions = {
						data : 'candidateDetails',
						columnDefs : [
								{
									field : "name",
									displayName : "Candidate Name",
									cellTemplate : "<a href='#/schedule/{{row.entity.id}}/{{row.entity.name}}'>{{row.entity.name}}</a>",
									width : "12%"
								},
								{
									field : "contactNumber",
									displayName : "Contact Number",
									width : "15%"
								},
								{
									field : "panNo",
									displayName : "PAN Number",
									width : "16%"
								},
								{
									field : "passportNumber",
									displayName : "Passport Number",
									width : "15%"
								},
								{
									field : "emailId",
									displayName : "Email ID",
									width : "15%"
								},
								{
									displayName : "Action",
									cellTemplate : '<a class="glyphicon glyphicon-edit" ng-click="updateModalDetails(row.entity)" style="margin-left:20%;cursor:pointer;" title="Request To Rescheduled" data-toggle="modal"	data-target="#basicModal" ></a>',
									width : "15%"
								}

						],
						showFilter : true,
						showFooter : true,
						showGroupPanel : true,
						showColumnMenu : true,
						pagingOptions : $scope.pagingOptions,
						enablePaging : false,
						totalServerItems : 'totalServerItems',
						filterOptions : $scope.filterOptions,
						enableRowSelection : false
					};

				});
