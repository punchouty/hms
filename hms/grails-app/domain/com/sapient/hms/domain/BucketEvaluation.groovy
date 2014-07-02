package com.sapient.hms.domain


class BucketEvaluation {
	
	Integer candidateScore
	SkillBucket skillBucket
	Date dateCreated
	Date lastUpdated

	
	
	static hasMany=[skillResult:SkillEvaluation]
	static belongsTo=[roundResult:RoundEvaluation,skillBucket:SkillBucket]

    static constraints = {
		lastUpdated nullable: true
    }

}
