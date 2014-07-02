package com.sapient.hms.domain

import com.sapient.hms.security.User

class InterviewDetails{

	String name
	User hiringperson
	String completionStatus
	String interviewMode
	Date dateCreated
	Date lastUpdated

		
	static hasMany=[results: RoundEvaluation]
	static belongsTo = [position:Position, hiringProcess: HiringProcess,candidate: CandidateDetails]
	
    static constraints = {
		lastUpdated nullable: true
    }

}
