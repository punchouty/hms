package com.sapient.hms.domain


class SkillEvaluation {
	
	Integer overAllScore
	Integer candidaterating
	Integer score
	String feedback
	Skill skill
	Date dateCreated
	Date lastUpdated

		
	static belongsTo=[bucketresult:BucketEvaluation,skill:Skill]

    static constraints = {
		lastUpdated nullable: true
    }

}
