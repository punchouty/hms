package com.sapient.hms.domain

import hms.HMSCommon
import java.util.Date;



class HiringProcess{
	
	String name
	Boolean defaultProcess
	Character status
	HMSCommon common
	static embedded = ['common']

	
	static belongsTo=[position: Position]
	static hasmany=[interviewDetails: InterviewDetails,rounds : AssessmentRound]
	
    static constraints = {
    }

}
