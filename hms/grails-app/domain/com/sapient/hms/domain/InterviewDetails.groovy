package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

import com.sapient.hms.security.User

class InterviewDetails{

	String name
	User hiringperson
	String completionStatus
	String interviewMode
	HMSCommon common
	static embedded = ['common']

		
	static hasMany=[results: RoundEvaluation]
	static belongsTo = [position:Position, hiringProcess: HiringProcess,candidate: CandidateDetails]
	
    static constraints = {
    }

}
