package com.sapient.hms.domain


class AssessmentRound{

	String name
	Position position
	Integer sequence
	Integer overAllCutOffScore
	Date dateCreated
	Date lastUpdated
	
	def skillBuckets =[]
	
	
	
	static hasMany=[roundresult:RoundEvaluation,skillbuckets:SkillBucket]
	
	static belongsTo=[hiringprocess:HiringProcess]
	
    static constraints = {
		lastUpdated nullable: true
    }
}

