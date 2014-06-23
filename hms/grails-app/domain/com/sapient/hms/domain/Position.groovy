package com.sapient.hms.domain

class Position {

	int id
    String name
	Date createdDate
	Date lastUpdatedDate
	
	//static hasMany = [interviewDetails : InterviewDetails, hiringProcesses : HiringProcess,skillBuckets: SkillBucket]
	
	
    static constraints = {
    }
}
