hms.controller('hiringRoundController', function ($scope, $routeParams, hiringService, $timeout) {
        $scope.loggedInUser = $('#loggedInUser').html();
        $scope.loggedInUserId = $('#loggedInUserId').html();
    $scope.modes = [{
        "name": "Telephonic",
        "code": "T"
    }, {
        "name": "Face-To-Face",
        "code": "F"
    }];

    $scope.candidateId = $routeParams.candidateId;
    $scope.candidateName = $routeParams.candidateName;
    $scope.scheduleRound_interviewId = $routeParams.interviewId;
    hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function (assessmentRounds) {
        $scope.rounds = assessmentRounds;
        checkRoundStatus();
    });

    $scope.scheduleInterview = function (roundId, interviewerId, round) {
    	var round1 = round;
        hiringService.updateRound({
            "evaluationRoundId": roundId,
            "interviewerId": interviewerId,
            "interviewTime": round.interviewTime,
            "interviewMode": round.selectedMode.code
        }).$promise.then(function (round) {
        	if(round.error){
        		$scope.message = "Interview Schedule Failed because Assessment status is ";
        		$scope.status = round1.assessmentStatus;
                $scope.class = "error";
                $scope.isCompleted = true;
                $timeout(function(){
                	$scope.isCompleted = false;
        		},5000);        	
            }else{
        		 hiringService.getRoundSchedulesForInterview($scope.scheduleRound_interviewId).$promise.then(function (assessmentRounds) {
                     $scope.rounds = assessmentRounds; 
                     checkRoundStatus();
                     $scope.message = "Interview Schedule Successfully ";
                     $scope.class = "success";
                     $scope.isCompleted = true;
                     $timeout(function(){
                     	$scope.isCompleted = false;
             		},3000);
                 });
        	}
           
        });

    }

    function checkRoundStatus(){
    	var flag = true;
        $scope.rounds.noData = false;
        for (var i = 0; i < $scope.rounds.length; i++) {
            if (flag) {
                $scope.rounds[i].show = true;
                $scope.rounds.noData = true;
                flag = false;
            }
            if (i > 0) {
                if ($scope.rounds[i - 1].assessmentStatus == 6) {
                    $scope.rounds[i].show = true;
                    $scope.rounds.noData = true;
                } else {
                    $scope.rounds[i].show = false;
                }

            }
        }
    };
    
    $scope.isScheduled = function (round) {
        if (round.interviewerName && round.interviewTime && round.selectedMode) 
        	return false;
        else
        	return true; 
    }

    hiringService.getInterviewerDetails().$promise.then(function (interviewerDetails) {
        $scope.interviewers = interviewerDetails;
        $scope.setInterviewer = function (site, round) {
            round.interviewerId = site.id;
        };
    });

    $scope.updateStatus = function (round, status) {
        if (round.assessmentStatus === null) round.assessmentStatus = 1;
        if (hiringService.validateStatusChange(
        round.assessmentStatus, status)) {
            round.assessmentStatus = status;
            hiringService.updateRound2(round).$promise.then(function () {
                $scope.message = "Successfully";
                $scope.class = "success";
                $scope.isCompleted = true;
                $scope.statusTo = "";
                $scope.center = " ";
                $scope.status = "";
                $timeout(function(){
                	$scope.isCompleted = false;
        		},2000);
            });
        } else {
            $scope.message = " failed as not allowed to move from ";
            $scope.statusTo = round.assessmentStatus;
            $scope.center = " to ";
            $scope.status = status;
            $scope.class = "error";
            $scope.isCompleted = true;
            $timeout(function(){
            	$scope.isCompleted = false;
    		},2000);
        }
    }

});