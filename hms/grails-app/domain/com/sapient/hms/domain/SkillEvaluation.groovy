package com.sapient.hms.domain


class SkillEvaluation {
	
	Integer candidateRating
	Integer candidateSkillScore
	String feedback
	Date dateCreated
	Date lastUpdated

		
	static belongsTo=[bucketEvaluation:BucketEvaluation,skillItem:SkillItem]

    static constraints = {
		candidateRating nullable: true
		candidateSkillScore nullable: true
		feedback nullable: true
    }

}
