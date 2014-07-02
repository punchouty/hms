package com.sapient.hms.domain


class SkillBucket {

	String name
	def skills=[]	
	Integer cutOffScore
	AssessmentRound assessmentRound
	Date dateCreated
	Date lastUpdated

	
	static hasMany=[skill:Skill,bucketresult:BucketEvaluation]
	static belongsTo=[position:Position,assessmentRound:AssessmentRound]
	
    static constraints = {
		lastUpdated nullable: true
    }
}
