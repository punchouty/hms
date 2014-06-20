package com.sapient.hms.domain

class InterviewDetails {

	int id
	String name
	String completionStatus
	Date startTime
	Date endTime
	Position title
	User hiringperson
	User interviewer
	String interviewMode
	RoundEvaluationResult evaluationDetails;
    static constraints = {
    }
}
