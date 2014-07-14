package com.sapient.hms.domain


class SkillBucket {

	String name
	Integer cutOffScore
	Date dateCreated
	Date lastUpdated

	static hasMany=[skillItems:SkillItem]
	static belongsTo=[position:Position, assessmentRound:AssessmentRound]
	
    static constraints = {
    }
}
