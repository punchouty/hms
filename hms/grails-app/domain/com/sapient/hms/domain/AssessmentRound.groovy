package com.sapient.hms.domain

class AssessmentRound {

	int id
	String name
	Position position
	int sequence
	int overAllCutOffScore
	def skillBuckets =[]
	
	static hasMany=[roundresult:RoundEvaluationResult,skillbuckets:SkillBucket]
	
	static belongsTo=[hiringprocess:HiringProcess]
	
    static constraints = {
    }
}
