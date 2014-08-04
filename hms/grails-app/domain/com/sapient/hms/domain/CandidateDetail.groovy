package com.sapient.hms.domain


class CandidateDetail{

	String name
	String location
	String emailId
	String panNo
	Date dateCreated
	Date lastUpdated

	static hasMany = [interviewDetails : InterviewDetail]
	
	
    static constraints = {
}
}