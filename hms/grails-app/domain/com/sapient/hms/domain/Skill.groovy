package com.sapient.hms.domain

class Skill {
	
	int id
	String name
	int expectedSkillrating
	int cutOffScore
	int weight
	
	static hasMany=[skillResult:SkillEvaluationresult]
	static belongsTo=[skillBucket:SkillBucket]
    static constraints = {
    }
}
