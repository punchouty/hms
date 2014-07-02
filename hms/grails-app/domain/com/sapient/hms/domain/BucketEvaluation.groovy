package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class BucketEvaluation {
	
	Integer candidateScore
	SkillBucket skillBucket
	HMSCommon common
	static embedded = ['common']

	
	
	static hasMany=[skillResult:SkillEvaluation]
	static belongsTo=[roundResult:RoundEvaluation,skillBucket:SkillBucket]

    static constraints = {
    }

}
