package com.sapient.hms.domain

class SkillEvaluationresult {
	
	int id
	int overAllScore
	int candidaterating
	int score
	String feedback
	Skill skill
	
	static belongsTo=[bucketresult:BucketEvaluationResult,skill:Skill]

    static constraints = {
    }
}
