package com.sapient.hms.domain

class RoundEvaluationResult {
	
	int id
	Date startTime
	Date endTime
	String assessmentStatus
	int candidateFinalScore
	boolean willingToHire
	String hireRejectreason
	String recommendation
	String guideline
	String instructions
	
	static hasMany=[bucketResult:BucketEvaluationResult]
	
	static belongsTo = [interviewDetails:InterviewDetails]

	    static constraints = {
    }
}
