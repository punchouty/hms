package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class Skill{
	
	String name
	int expectedSkillrating
	int cutOffScore
	int weight
	HMSCommon common
	static embedded = ['common']

	
	static hasMany=[skillResult:SkillEvaluationresult]
	static belongsTo=[skillBucket:SkillBucket]
	
    static constraints = {
    }

}
