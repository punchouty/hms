hms
		.controller(
				'hiringRoundController',
				function($scope, $routeParams, hiringService) {
					hms
							.controller(
									'hiringRoundController',
									function($scope, $routeParams,
											hiringService) {

										$scope.name = 'hiringRoundController';
										$scope.loggedInUser = $('#loggedInUser')
												.html();
										$scope.loggedInUserId = $(
												'#loggedInUserId').html();

										// Schedule Rounds
										$scope.scheduleRound_interviewId = $routeParams.interviewId;
										hiringService
												.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise
												.then(function(assessmentRounds) {
													$scope.rounds = assessmentRounds;
													$scope.rounds[0].interviewTime = "03/04/2014 13:00";
													alert($scope.rounds[0].interviewTime);
													// angular.forEach($scope.rounds,
													// function(value, key){
													// value.
													// //alert(value.interviewTime)
													// });
												});

										$scope.scheduleInterview = function(
												roundId, interviewerId,
												interviewTime) {

											hiringService
													.updateRound({
														"evaluationRoundId" : roundId,
														"interviewerId" : interviewerId,
														"interviewTime" : document
																.getElementById("dt").value
													}).$promise.then(function(
													round) {
											});

										}

										hiringService.getInterviewerDetails().$promise
												.then(function(
														interviewerDetails) {
													$scope.interviewers = interviewerDetails;
													$scope.setInterviewer = function(
															site, round) {
														round.interviewerId = site.id;
													};
												});

										$scope.meetsCriteria = function(round) {
											if (round.interviewerId
													&& round.interviewTime)
												return false
											else
												return true
										}

										$scope.changeInterviewer = function(
												round) {
											round.interviewerId = "";
										}

									});

					$scope.modes = [ {
						"name" : "Telephonic",
						"code" : "T"
					}, {
						"name" : "Face-To-Face",
						"code" : "F"
					} ];
					$scope.name = 'hiringRoundController';
					$scope.loggedInUser = $('#loggedInUser').html();
					$scope.loggedInUserId = $('#loggedInUserId').html();

					// Schedule Rounds
					$scope.scheduleRound_interviewId = $routeParams.interviewId;
					hiringService
							.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise
							.then(function(assessmentRounds) {
								$scope.rounds = assessmentRounds;
							});

					$scope.scheduleInterview = function(roundId, interviewerId,
							round) {
						hiringService.updateRound({
							"evaluationRoundId" : roundId,
							"interviewerId" : interviewerId,
							"interviewTime" : round.interviewTime,
							"interviewMode" : round.selectedMode.code
						}).$promise
								.then(function(round) {
									hiringService
											.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise
											.then(function(assessmentRounds) {
												$scope.rounds = assessmentRounds;
												$scope.message = "Interview Schedule Successfully ";
												$scope.class = "success";
												$scope.isCompleted = true;
											});
								});

					}

					$scope.isScheduled = function(round) {

						if (round.interviewerName && round.interviewTime
								&& round.selectedMode)
							return false;
						else
							return true;
					}

					hiringService.getInterviewerDetails().$promise
							.then(function(interviewerDetails) {
								$scope.interviewers = interviewerDetails;
								$scope.setInterviewer = function(site, round) {
									round.interviewerId = site.id;
								};
							});

					$scope.updateStatus = function(round, status) {
						if (round.assessmentStatus === null)
							round.assessmentStatus = 1;
						if (hiringService.validateStatusChange(
								round.assessmentStatus, status)) {
							round.assessmentStatus = status;
							hiringService.updateRound2(round).$promise
									.then(function() {
										$scope.message = "Successfully";
										$scope.class = "success";
										$scope.isCompleted = true;
										$scope.statusTo = "";
										$scope.center = " ";
										$scope.status = "";
									});
						} else {
							$scope.message = " failed as not allowed to move from ";
							$scope.statusTo = round.assessmentStatus;
							$scope.center = " to ";
							$scope.status = status;
							$scope.class = "error";
							$scope.isCompleted = true;
						}
					}
				});
