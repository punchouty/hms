package com.sapient.hms.domain


class CandidateDetail{

	String name
	String location
	Date dateCreated
	Date lastUpdated

	static hasMany = [InterviewDetails : InterviewDetail]
	
	
    static constraints = {
}
}