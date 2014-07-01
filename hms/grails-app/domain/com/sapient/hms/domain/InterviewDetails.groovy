package com.sapient.hms.domain

import com.sapient.hms.security.User

class InterviewDetails {

	int id
	String name
	User hiringperson
	String completionStatus
	String interviewMode
		
	static hasMany=[results: RoundEvaluationResult]
	static belongsTo = [position:Position, hiringProcess: HiringProcess,candidate: CandidateDetails]
	
    static constraints = {
    }
}
