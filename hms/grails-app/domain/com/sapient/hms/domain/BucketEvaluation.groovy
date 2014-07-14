package com.sapient.hms.domain


class BucketEvaluation {
	
	Integer candidateBucketScore
	Date dateCreated
	Date lastUpdated

	
	
	static hasMany=[skillEvaluations:SkillEvaluation]
	static belongsTo=[roundEvaluation:RoundEvaluation,skillBucket:SkillBucket]

    static constraints = {
		candidateBucketScore nullable: true
    }

}
