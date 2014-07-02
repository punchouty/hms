package com.sapient.hms.domain


class SkillEvaluation {
	
	Integer overAllScore
	Integer candidaterating
	Integer score
	String feedback
	Date dateCreated
	Date lastUpdated

		
	static belongsTo=[bucketEvaluation:BucketEvaluation,skill:Skill]

    static constraints = {
		overAllScore nullable: true
		candidaterating nullable: true
		score nullable: true
		feedback nullable: true
    }

}
