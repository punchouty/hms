package com.sapient.hms.domain




class HiringProcess{
	
	String name
	Boolean defaultProcess
	Character status
	Date dateCreated
	Date lastUpdated
	
	
	static hasMany=[assessmentRounds: AssessmentRound]
	static belongsTo=[position: Position]
	
	
    static constraints = {
    }

	static mapping = {
		 assessmentRounds sort: 'id', order: 'asc'
	}
}
