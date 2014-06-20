package com.sapient.hms.domain

class SkillBucket {

	int id
	String name
	def skills=[]
	int cutOffScore
	AssessmentRound assessmentRound
    static constraints = {
    }
}
