package com.sapient.hms.domain

class SkillBucket {

	int id
	String name
	def skills=[]
	int cutOffScore
	AssessmentRound assessmentRound
	
	static hasMany=[skill:Skill,bucketresult:BucketEvaluationResult]
	static belongsTo=[position:Position,assessmentRound:AssessmentRound]
	
    static constraints = {
    }
}
