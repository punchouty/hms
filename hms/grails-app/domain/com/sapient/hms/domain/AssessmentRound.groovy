package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class AssessmentRound{

	String name
	Position position
	Integer sequence
	Integer overAllCutOffScore
	HMSCommon common
	static embedded = ['common']
	
	def skillBuckets =[]
	
	
	
	static hasMany=[roundresult:RoundEvaluationResult,skillbuckets:SkillBucket]
	
	static belongsTo=[hiringprocess:HiringProcess]
	
    static constraints = {
    }
}

