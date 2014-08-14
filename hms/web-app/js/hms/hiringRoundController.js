
hms
		.controller(
				'hiringRoundController',
				function($scope, $routeParams, hiringService) {
					hms
							.controller(
									'hiringRoundController',
									function($scope, $routeParams,
											hiringService) {
										alert("hi2");
										$scope.name = 'hiringRoundController';
										$scope.loggedInUser = $('#loggedInUser')
												.html();
										$scope.loggedInUserId = $(
												'#loggedInUserId').html();
										
									/*	hiringService
												.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise
												.then(function(assessmentRounds) {
												
													$scope.rounds = assessmentRounds;
													var flag = true;
													
												for(var i=0;i<$scope.rounds.length;i++){
													if(flag){
														$scope.rounds[i].show = true;
														flag= false;
													}
                                                   if(i>0){
                                                	  if($scope.rounds[i-1].assessmentStatus == 6){
                                                		  $scope.rounds[i].show = true;
														  }
                                                   }
													
												}
													
													console.log($scope.rounds);
												});*/

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

					$scope.candidateId =$routeParams.candidateId;
					$scope.candidateName =$routeParams.candidateName;
					$scope.scheduleRound_interviewId = $routeParams.interviewId;
					hiringService
							.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise
							.then(function(assessmentRounds) {
								$scope.rounds = assessmentRounds;
								var flag = true;
								$scope.rounds.noData=false;
								for(var i=0;i<$scope.rounds.length;i++){
									if(flag){
										$scope.rounds[i].show = true;
										$scope.rounds.noData=true;
										flag= false;
									}
                                   if(i>0){
                                	  if($scope.rounds[i-1].assessmentStatus == 6){
                                		  $scope.rounds[i].show = true;
                                		  $scope.rounds.noData=true;
										  }
                                	  else
                                		  {
                                		  $scope.rounds[i].show = false;
                                		  }
                                	  
                                   }
								}
								
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
