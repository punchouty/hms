package com.sapient.hms.domain

import com.sapient.hms.security.User

class RoundEvaluationResult {
	
	int id
	CandidateDetails candidate
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
	AssessmentRound round
	
	static hasMany=[bucketResult:BucketEvaluationResult]
	
	static belongsTo = [interviewDetails:InterviewDetails,round:AssessmentRound]

	    static constraints = {
    }
}
