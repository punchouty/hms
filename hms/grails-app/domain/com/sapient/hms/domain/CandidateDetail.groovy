package com.sapient.hms.domain


class CandidateDetail{

	String name
	String emailId
	String panNo
	String contactNumber
	String passportNumber
	Date dateCreated
	Date lastUpdated

	static hasMany = [interviewDetails : InterviewDetail]
	
	
    static constraints = {
		emailId (unique:true, email:true )
		panNo (unique:true)
		passportNumber unique:true		
	}

}