package com.sapient.hms.domain


class Position{

    String name
	Date dateCreated
	Date lastUpdated

	
	static hasMany = [hiringProcesses : HiringProcess,skillBuckets: SkillBucket]
	
	
    static constraints = {
    }

}
