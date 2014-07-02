package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class SkillEvaluation {
	
	Integer overAllScore
	Integer candidaterating
	Integer score
	String feedback
	Skill skill
	HMSCommon common
	static embedded = ['common']

		
	static belongsTo=[bucketresult:BucketEvaluation,skill:Skill]

    static constraints = {
    }

}
