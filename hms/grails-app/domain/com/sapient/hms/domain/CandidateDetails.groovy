package com.sapient.hms.domain


class CandidateDetails{

	String name
	String location
	Date dateCreated
	Date lastUpdated

	static hasMany = [interviewDetails : InterviewDetails]
	
	
    static constraints = {
		lastUpdated nullable: true
}
}