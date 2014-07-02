package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class BucketEvaluationResult {
	
	Integer candidateScore
	SkillBucket skillBucket
	HMSCommon common
	static embedded = ['common']

	
	
	static hasMany=[skillResult:SkillEvaluationresult]
	static belongsTo=[roundResult:RoundEvaluationResult,skillBucket:SkillBucket]

    static constraints = {
    }

}
