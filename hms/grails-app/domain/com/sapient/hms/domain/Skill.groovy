package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class Skill{
	
	String name
	Integer expectedSkillrating
	Integer cutOffScore
	Integer weight
	HMSCommon common
	static embedded = ['common']

	
	static hasMany=[skillResult:SkillEvaluation]
	static belongsTo=[skillBucket:SkillBucket]
	
    static constraints = {
    }

}
