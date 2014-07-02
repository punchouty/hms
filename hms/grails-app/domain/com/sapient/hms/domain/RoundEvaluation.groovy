package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

import com.sapient.hms.security.User

class RoundEvaluation{
	
	Date scheduledTime
	Date actualStartTime
	Date actualEndTime
	String assessmentStatus
	int candidateFinalScore
	boolean willingToHire
	String hireRejectreason
	String recommendation
	String guideline
	String instructions
	User interviewer
	HMSCommon common
	static embedded = ['common']

	
	static hasMany=[bucketResult:BucketEvaluation]
	
	static belongsTo = [interviewDetails:InterviewDetails,round:AssessmentRound]

	    static constraints = {
    }

}
