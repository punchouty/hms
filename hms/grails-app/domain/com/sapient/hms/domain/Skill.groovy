package com.sapient.hms.domain


class Skill{
	
	String name
	Integer expectedSkillrating
	Integer cutOffScore
	Integer weight
	Date dateCreated
	Date lastUpdated

	
	static hasMany=[skillEvaluations:SkillEvaluation]
	static belongsTo=[skillBucket:SkillBucket]
	
    static constraints = {
    }

}
