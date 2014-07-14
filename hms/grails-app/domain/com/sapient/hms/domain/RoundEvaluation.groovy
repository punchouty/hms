package com.sapient.hms.domain

import com.sapient.hms.security.User

class RoundEvaluation{
	
	Date scheduledTime
	Date actualStartTime
	Date actualEndTime
	String assessmentStatus
	Integer candidateRoundScore
	Boolean willingToHire
	String hireRejectreason
	String recommendation
	String guideline
	String instructions
	User interviewer
	Date dateCreated
	Date lastUpdated

	
	static hasMany=[bucketEvaluations:BucketEvaluation]
	
	static belongsTo = [interviewDetail:InterviewDetail,assessmentRound:AssessmentRound]

	    static constraints = {
			scheduledTime nullable: true
			actualStartTime nullable: true
			actualEndTime nullable: true
			assessmentStatus nullable: true
			candidateRoundScore nullable: true
			willingToHire nullable: true
			hireRejectreason nullable: true
			recommendation nullable: true
			guideline nullable: true
			instructions nullable: true
			interviewer nullable: true
		}
    }


