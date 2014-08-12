package com.sapient.hms.domain


class AssessmentRound{

	String name
	Position position
	Integer sequence
	Integer overAllCutOffScore
	Date dateCreated
	Date lastUpdated
	Boolean isDisabled
	
	static hasMany=[skillBuckets:SkillBucket]
	
	static belongsTo=[hiringProcess:HiringProcess]
	
    static constraints = {
    }
}

