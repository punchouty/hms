package com.sapient.hms.domain

class RoundEvaluationResult {
	
	int id
	CandidateDetails candidate
	Date startTime
	Date endTime
	String assessmentStatus
	int candidateFinalScore
	boolean willingToHire
	String hireRejectreason
	String recommendation
	String guideline
	String instructions
	AssessmentRound round
	
	static hasMany=[bucketResult:BucketEvaluationResult]
	
	static belongsTo = [interviewDetails:InterviewDetails,round:AssessmentRound]

	    static constraints = {
    }
}
