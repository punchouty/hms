package com.sapient.hms.domain


class BucketEvaluation {
	
	Integer candidateScore
	Date dateCreated
	Date lastUpdated

	
	
	static hasMany=[skillEvaluations:SkillEvaluation]
	static belongsTo=[roundEvaluation:RoundEvaluation,skillBucket:SkillBucket]

    static constraints = {
		candidateScore nullable: true
    }

}
