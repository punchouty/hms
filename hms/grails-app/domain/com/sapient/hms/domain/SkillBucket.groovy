package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class SkillBucket {

	String name
	def skills=[]
	int cutOffScore
	AssessmentRound assessmentRound
	HMSCommon common
	static embedded = ['common']

	
	static hasMany=[skill:Skill,bucketresult:BucketEvaluation]
	static belongsTo=[position:Position,assessmentRound:AssessmentRound]
	
    static constraints = {
    }
}
