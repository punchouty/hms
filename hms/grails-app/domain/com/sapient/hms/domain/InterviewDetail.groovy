package com.sapient.hms.domain

import com.sapient.hms.security.User

class InterviewDetail{

	String name
	User hiringperson
	String completionStatus
	String interviewMode
	Date dateCreated
	Date lastUpdated

		
	static hasMany=[roundEvaluations: RoundEvaluation]
	static belongsTo = [position:Position, hiringProcess: HiringProcess,candidateDetail: CandidateDetail]
	
    static constraints = {
    }

}
