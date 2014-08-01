
'use strict';

/* Controllers */

hms
		.controller(
				'hiringAssessRoundController',
				function($scope, $route, hiringService) {

					$scope.loggedInUser = $('#loggedInUser').html();
					$scope.loggedInUserId = $('#loggedInUserId').html();
					$scope.round = "domain";

					var template = '<a ng-click="updateStatus(row.entity, 2)" class="glyphicon glyphicon-time" style="margin-left:20%;cursor:pointer;" title="Evaluate"></a>'
							+

							'<a class="glyphicon glyphicon-refresh" ng-click="updateStatus(row.entity, 3)" style="margin-left:20%;cursor:pointer;" title="Request To Rescheduled" ></a>'
							+

							'<a class="glyphicon glyphicon-trash" ng-click="updateStatus(row.entity, 4)"  style="margin-left:20%;cursor:pointer;" title="Request To Cancel "></a>'

					
				 hiringService.getScheduledRounds($scope.loggedInUserId).$promise
							.then(function(interviews) {
								$scope.interviews = interviews;
							});
					 
/*					$scope.filterOptions = {
						filterText : "",
						useExternalFilter : false
					};
					$scope.totalServerItems = 0;
					$scope.pagingOptions = {
						pageSizes : [ 5, 10, 20 ],
						pageSize : 5,
						currentPage : 1
					};
					$scope.setPagingData = function(data, page, pageSize) {
						var pagedData = data.slice((page - 1) * pageSize, page
								* pageSize);
						$scope.myData = pagedData;
						$scope.totalServerItems = data.length;
						if (!$scope.$$phase) {
							$scope.$apply();
						}
					};
					$scope.getPagedDataAsync = function(pageSize, page,
							searchText) {
						setTimeout(
								function() {
									var data;
									if (searchText) {
										var ft = searchText.toLowerCase();
										hiringService
												.getScheduledRounds($scope.loggedInUserId).$promise
												.then(function(interviews) {
													$scope.interviews = interviews;
													$scope.setPagingData(
															interviews, page,
															pageSize);
												});

									} else {
										hiringService
												.getScheduledRounds($scope.loggedInUserId).$promise
												.then(function(interviews) {
													$scope.setPagingData(
															interviews, page,
															pageSize);
												});
									}
								}, 100);
					};

					$scope.getPagedDataAsync($scope.pagingOptions.pageSize,
							$scope.pagingOptions.currentPage);

					$scope.$watch('pagingOptions', function(newVal, oldVal) {
						if (newVal !== oldVal
								&& newVal.currentPage !== oldVal.currentPage) {
							$scope.getPagedDataAsync(
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);
					$scope.$watch('filterOptions', function(newVal, oldVal) {
						if (newVal !== oldVal) {
							$scope.getPagedDataAsync(
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);*/
					$scope.gridOptions = {
						data : 'interviews',
						columnDefs : [
								{
									field : "roundName",
									displayName : "Round Name",
									width : "10%",
									pinned : true
								},
								{
									field : "scheduledDate | date: 'dd-MM-yyyy HH:mm'",
									displayName : "Scheduled Date(DD-MM-YYYY HH:MM)",
									width : "25%"
								},
								{
									field : "candidateName",
									displayName : "Candidate Name",
									width : "15%"
								},
								{
									field : "hiringPersonName",
									displayName : "Hiring Person",
									width : "14%"
								},
								{
									field : "assessmentStatus |renderAssessmentStatus",
									displayName : "Assessment Status",
									width : "16%"
								}, {
									displayName : "Action",
									cellTemplate : template,
									width : "20%"
								} ],
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

					$scope.updateStatus = function(round, status) {
						//event.preventDefault();
						if (hiringService.validateStatusChange(
								round.assessmentStatus, status)) {
							round.assessmentStatus = status;
							hiringService.updateRound2(round).$promise
									.then(function() {
										$scope.message = "Successfully";
										$scope.class = "success";
										$scope.isCompleted = true;
										$scope.statusTo ="";
										$scope.center = " ";
										$scope.status = "";
									});
							window.location.href = '#/assessment/'+round.evaluationRoundId;
							} else {
								$scope.message = " failed as not allowed to move from ";
								$scope.statusTo = round.assessmentStatus;
								$scope.center = " to ";
								$scope.status = status;
								$scope.class = "error";
								$scope.isCompleted = true;
						  }
					}

					// $scope.updateStatusAsRechudule = function(status){
					// hiringService.updateRoundStatus(status).$promise.then(function(){
					//       
					// hiringService.getRoundsByinterview($scope.loggedInUserId,$scope.selectedCandidate.id,$scope.selectedRoundId.id,$scope.selectedDate).$promise.then(function(interviewsByDetails)
					// {
					// $scope.interviews = interviews;
					// });
					// });
					// }
					// $scope.updateStatusAsCancel = function(status){
					// hiringService.updateRoundStatus(status).$promise.then(function(){
					//       
					// hiringService.getRoundsByinterview($scope.loggedInUserId,$scope.selectedCandidate.id,$scope.selectedRoundId.id,$scope.selectedDate).$promise.then(function(interviewsByDetails)
					// {
					//                                     $scope.interviews = interviews;
					//                                  });     
					//                     });
					//          } 
					//        
				});
