package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;

class Position{

    String name
	HMSCommon common
	static embedded = ['common']

	
	static hasMany = [interviewDetails : InterviewDetails, hiringProcesses : HiringProcess,skillBuckets: SkillBucket]
	
	
    static constraints = {
    }

}
