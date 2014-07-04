package com.sapient.hms.domain


class SkillEvaluation {
	
	Integer candidateRating
	Integer candidateSkillScore
	String feedback
	Date dateCreated
	Date lastUpdated

		
	static belongsTo=[bucketEvaluation:BucketEvaluation,skillItem:SkillItem]

    static constraints = {
		overAllScore nullable: true
		candidaterating nullable: true
		score nullable: true
		feedback nullable: true
    }

}
