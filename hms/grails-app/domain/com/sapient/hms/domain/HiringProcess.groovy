package com.sapient.hms.domain




class HiringProcess{
	
	String name
	Boolean defaultProcess
	Character status
	Date dateCreated
	Date lastUpdated

	
	static belongsTo=[position: Position]
	static hasmany=[interviewDetails: InterviewDetails,rounds : AssessmentRound]
	
    static constraints = {
		lastUpdated nullable: true
    }

}
