package com.sapient.hms.domain

import com.sapient.hms.security.User

class RoundEvaluation{
	
	Date scheduledTime
	Date actualStartTime
	Date actualEndTime
	String assessmentStatus
	Integer candidateFinalScore
	Boolean willingToHire
	String hireRejectreason
	String recommendation
	String guideline
	String instructions
	User interviewer
	Date dateCreated
	Date lastUpdated

	
	static hasMany=[bucketResult:BucketEvaluation]
	
	static belongsTo = [interviewDetails:InterviewDetails,round:AssessmentRound]

	    static constraints = {
			lastUpdated nullable: true
		}
    }


