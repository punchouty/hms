package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class CandidateDetails{

	String name
	String location
	HMSCommon common
	static embedded = ['common']

	static hasMany = [interviewDetails : InterviewDetails]
	
	
    static constraints = {

}
}