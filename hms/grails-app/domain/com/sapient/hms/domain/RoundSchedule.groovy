package com.sapient.hms.domain

import com.sapient.hms.security.User

class RoundSchedule {
	
	int id
	Position position
	HiringProcess hiringProcess
	AssessmentRound assessmentRound
	CandidateDetails candidate
	User interviewer
	Date interviewTime
	RoundEvaluationResult result
	
	
	static constraints = {
    }
}
