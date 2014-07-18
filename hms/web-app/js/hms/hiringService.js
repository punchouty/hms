hms.factory('hiringService', function($resource, $log){
	 
	var factory = {};
	 
	factory.getPositions = function (){
		return $resource('position').query();
		}
	
	factory.getHiringProcessesForPosition  = function(positionId){
		return $resource('hiringProcess/listByPosition/:positionId', {positionId:'@positionId'}).query({positionId:positionId});
		}
	
	factory.getAssessmentRoundsForProcess = function(processId){
		return $resource('assessmentRound/:processId', {processId:'@processId'}).query({processId:processId});
		}
	
	factory.getCandidateDetails = function (){
		return $resource('candidateDetails').query();
		}
	
	factory.getRoundSchedulesForInterview = function (interviewId){
		return $resource('roundEvaluation/listByInterview/:interviewId', {interviewId:'@interviewId'}).query({interviewId:interviewId});
    }
	
			
	factory.createCandidate = function(candidate){
		return $resource('candidateDetails/save', {}, {'save': {method:'POST'}}).save(candidate);
	}
	
	

	factory.createInterview = function(interviewDetail){
		return $resource('interviewDetails/save', {}, {'save': {method:'POST'}}).save(interviewDetail);
	}

	factory.getInterviewsByUser = function(userId){
		return $resource('interviewDetails/listByUser/:userId', {userId:'@userId'}).query({userId:userId});
	}

	factory.deleteInterview = function(id){
		return $resource('interviewDetails/delete', {}, {'delete': {method:'DELETE'}}).delete({'id':id});
	}
	
	factory.addCandidate = function(candidate){
		return $resource('candidateDetails/save', {}, {'save': {method:'POST'}}).save(candidate);
	}
	
	factory.getRoundsByinterview = function(userId){
	     return $resource('roundEvaluation/searchByInterview/:userId', {userId:'@userId'}).query({userId:userId});		
	}

	
	factory.updateRound = function(round){
        return $resource('roundEvaluation/update', {}, {'update': {method:'PUT'}}).update(round);

    }
	factory.getInterviewerDetails = function (){
		return $resource('roundEvaluation/listPanelUsers').query();
		}
		
		factory.getScheduledRounds = function (userId){
		return $resource('roundEvaluation/listScheduledRounds/:userId', {userId:'@userId'}).query({userId:userId});


    }

	factory.getEvaluationRound = function (evaluationRoundId){
			return $resource('roundEvaluation/show/:evaluationRoundId', {evaluationRoundId:'@evaluationRoundId'}).query({evaluationRoundId:evaluationRoundId});
    } 
	
	factory.updateSkills = function(skill){
		
        return $resource('skillEvaluation/update', {},{'update': {method:'PUT'}}).update(skill);

    }

	return factory;
});
