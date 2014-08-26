hms.factory('hiringService', function ($resource, $log) {

    var factory = {};

    factory.validateStatusChange = function (assessmentStatus, newstaus) {
        if (assessmentStatus == 1 && ((newstaus == 2) || (newstaus == 3) || (newstaus == 4) || (newstaus == 6))) return true;
        else if (assessmentStatus == 2 && ((newstaus == 3) || (newstaus == 5) || (newstaus == 6) || (newstaus == 2))) return true;
        else if (assessmentStatus == 3 && newstaus == 1) return true;
        else if (assessmentStatus == 5 && newstaus == 1) return true;
        else return false;
    }

    factory.getPositions = function () {
        return $resource('position').query();
    }

    factory.getHiringProcessesForPosition = function (positionId) {
        return $resource('hiringProcess/listByPosition/:positionId', {
            positionId: '@positionId'
        }).query({
            positionId: positionId
        });
    }

    factory.getAssessmentRoundsForProcess = function (processId) {
        return $resource('assessmentRound/:processId', {
            processId: '@processId'
        }).query({
            processId: processId
        });
    }

    factory.getCandidateDetails = function () {
        return $resource('candidateDetails').query();
    }

    factory.getRoundSchedulesForInterview = function (interviewId) {
        return $resource('roundEvaluation/listByInterview/:interviewId', {
            interviewId: '@interviewId'
        }).query({
            interviewId: interviewId
        });
    }


    factory.createCandidate = function (candidate) {
        return $resource('candidateDetails/save', {}, {
            'save': {
                method: 'POST'
            }
        }).save(candidate);
    }



    factory.createInterview = function (interviewDetail) {
        return $resource('interviewDetails/save', {}, {
            'save': {
                method: 'POST'
            }
        }).save(interviewDetail);
    }

    factory.getInterviewsByUser = function (userId) {
        return $resource('interviewDetails/listByUser/:userId', {
            userId: '@userId'
        }).query({
            userId: userId
        });
    }

    factory.deleteInterview = function (id) {
        return $resource('interviewDetails/delete', {}, {
            'delete': {
                method: 'DELETE'
            }
        }).delete({
            'id': id
        });
    }

    factory.addCandidate = function (candidate) {
        return $resource('candidateDetails/save', {}, {
            'save': {
                method: 'POST'
            }
        }).save(candidate);
    }

    factory.updateCandidateDetails = function (data) {
        return $resource('candidateDetails/update', {}, {
            'update': {
                method: 'PUT'
            }
        }).update(data);
    }

    factory.getRoundsByinterview = function (userId) {
        return $resource('roundEvaluation/searchByInterview/:userId', {
            userId: '@userId'
        }).query({
            userId: userId
        });
    }


    factory.updateRound2 = function (round) {
        return $resource('roundEvaluation/update2', {}, {
            'update': {
                method: 'PUT'
            }
        }).update(round);

    }

    factory.updateRound = function (round) {
        return $resource('roundEvaluation/update', {}, {
            'update': {
                method: 'PUT'
            }
        }).update(round);
    }
    factory.getInterviewerDetails = function () {
        return $resource('roundEvaluation/listPanelUsers').query();
    }

    factory.getScheduledRounds = function (userId, roundName) {
    	return $resource('roundEvaluation/listScheduledRounds',{}, {
    		 'update': {
                 method: 'PUT',
                 isArray: true
             }
        }).update({
            userId: userId,roundName: roundName
        });
    }

    factory.getEvaluationRound = function (evaluationRoundId) {
        return $resource('roundEvaluation/show/:evaluationRoundId', {
            evaluationRoundId: '@evaluationRoundId'
        }).get({
            evaluationRoundId: evaluationRoundId
        });
    }

    factory.searchCandidate = function (candidate) {
        return $resource('candidateDetails/search', {}, {
            'save': {
                method: 'POST',
                isArray: true
            }
        }).save(candidate);
    }
    return factory;
});