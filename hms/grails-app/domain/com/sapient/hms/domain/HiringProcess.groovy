package com.sapient.hms.domain



class HiringProcess {
	
	int id
	String name
	Date createdDate
	Date lastUpdatedDate
	boolean defaultProcess
	char status
	
	static belongsTo=[position: Position]
	static hasmany=[interviewDetails: InterviewDetails,rounds : AssessmentRound]
	
    static constraints = {
    }
}
