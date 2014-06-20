package com.sapient.hms.domain

class BucketEvaluationResult {
	
	int candidateScore
	int id
	SkillBucket skillBucket
	
	static hasMany=[skillResult:SkillEvaluationresult]
	static belongsTo=[roundResult:RoundEvaluationResult,skillBucket:SkillBucket]

    static constraints = {
    }
}
