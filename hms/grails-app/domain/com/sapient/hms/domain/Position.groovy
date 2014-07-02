package com.sapient.hms.domain


class Position{

    String name
	Date dateCreated
	Date lastUpdated

	
	static hasMany = [interviewDetails : InterviewDetails, hiringProcesses : HiringProcess,skillBuckets: SkillBucket]
	
	
    static constraints = {
		lastUpdated nullable: true
    }

}
