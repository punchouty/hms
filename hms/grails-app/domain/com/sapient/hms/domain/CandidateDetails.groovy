package com.sapient.hms.domain

class CandidateDetails {

	int id
	String name
	String location
	
	static hasMany = [interviewDetails : InterviewDetails]
    static constraints = {
    }
}
