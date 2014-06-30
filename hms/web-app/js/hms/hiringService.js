hms.factory('hiringService', function($resource, $log){
	 
	var factory = {};
	 
	factory.getPositions = function (){
		return $resource('position').query();
		}
	
	factory.getHiringProcessesForPosition  = function(positionId){
		return $resource('hiringProcess/:positionId', {positionId:'@positionId'}).query({positionId:positionId});
		}
	
	factory.getAssessmentRoundsForProcess = function(processId){
		return $resource('assessmentRound/:processId', {processId:'@processId'}).query({processId:processId});
		}
	
	factory.getCandidateDetails = function (subStr){
		return $resource('candidateDetails/:subStr', {subStr:'@subStr'}).query({subStr:subStr});
		}
	
	factory.getRoundSchedulesForInterview = function (interviewId){
		return $resource('roundSchedule/:interviewId', {interviewId:'@interviewId'}).query({interviewId:interviewId});
		}
	
			
	factory.createCandidate = function(candidate){
		return $resource('candidateDetails/save', {}, {'save': {method:'POST'}}).save(candidate);
	}
	
	factory.scheduleRound = function(scheduleRound){
		return $resource('roundSchedule/save', {}, {'save': {method:'POST'}}).save(scheduleRound);
	}

	return factory;
});