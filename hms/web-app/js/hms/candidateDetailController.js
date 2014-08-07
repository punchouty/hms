'use strict';

/* Controllers */

hms
		.controller(
				'candidateDetailController',
				function($scope, $routeParams, hiringService) {
					$scope.loggedInUser = $('#loggedInUser').html();
					$scope.loggedInUserId = $('#loggedInUserId').html();
					$scope.showMessage = false;
										
					$scope.addCandidate = function() {
						hiringService.addCandidate({
							"name" : $scope.newName,
							"emailId" : $scope.emailId,
							"panNo" : $scope.panNumber,
							"contactNumber": $scope.contactNumber,
							"passportNumber": $scope.passportNumber,
							"dateCreated" : new Date()
						}).$promise.then(function(response) {
							
							if(response.error){
								$scope.showMessage = true;
							}else{
								$scope.candidateDetails = [response];
							}
						    $scope.newName = "";
							$scope.emailId = "";
							$scope.panNumber = "";
							$scope.contactNumber= "";
							$scope.passportNumber = "";
						});
					}
					
					$scope.searchCandidate = function(){
						hiringService.searchCandidate({
							"name" : $scope.newName,
							"emailId" : $scope.emailId,
							"panNo" : $scope.panNumber,
							"contactNumber": $scope.contactNumber,
							"passportNumber": $scope.passportNumber,
							"dateCreated" : new Date()
						}).$promise.then(function(candidateDetails) {
							$scope.candidateDetails = candidateDetails;
						    $scope.newName = "";
							$scope.emailId = "";
							$scope.panNumber = "";
							$scope.contactNumber= "";
							$scope.passportNumber = "";
						});
					}
					
					$scope.clearForm = function() {
						    $scope.newName = "";
							$scope.emailId = "";
							$scope.panNumber = "";
							$scope.contactNumber= "";
							$scope.passportNumber = "";					
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
									}
							   ],
								showFilter : true,						
								showFooter : true,
								showGroupPanel : true,
								//showColumnMenu : true,
								//pagingOptions : $scope.pagingOptions,
								//enablePaging : false,
								//totalServerItems : 'totalServerItems',
								//filterOptions : $scope.filterOptions,
								enableRowSelection : false
						};

					
				});
