package com.sapient.hms.domain


class SkillItem{
	
	String name
	Integer expectedSkillrating
	Integer cutOffScore
	Integer weight
	Date dateCreated
	Date lastUpdated
	
	static belongsTo=[skillBucket:SkillBucket]
	
    static constraints = {
    }

}
