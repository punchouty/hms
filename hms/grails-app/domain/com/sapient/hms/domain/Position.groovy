package com.sapient.hms.domain


class Position{

    String name
	Date dateCreated
	Date lastUpdated

	
	static hasMany = [interviewDetails : InterviewDetail, hiringProcesses : HiringProcess,skillBuckets: SkillBucket]
	
	
    static constraints = {
    }

}
