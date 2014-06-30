'use strict';

/* Services */

hms.factory('hiringService', function($resource, $log){
	 
	var factory = {};
	 
	factory.getPositions(){
		return $resource('position').query();
		}
	
	factory.getHiringProcessesForPosition(positionId){
		return $resource('hiringProcess/:positionId', {positionId:'@positionId'}).query({positionId:positionId});
		}
	
	factory.getAssessmentRoundsForProcess(processId){
		return $resource('assessmentRound/:processId', {processId:'@processId'}).query({processId:processId});
		}
	
	factory.getCandidateDetails(subStr){
		return $resource('candidateDetails/:subStr', {subStr:'@subStr'}).query({subStr:subStr});
		}
	
	factory.getRoundSchedulesForInterview(interviewId){
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