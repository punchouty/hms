package com.sapient.hms.service

import com.sapient.hms.domain.AssessmentRound;
import com.sapient.hms.domain.HiringProcess;
import com.sapient.hms.domain.Position;
import com.sapient.hms.security.User;

class InterviewDetailsService {

    def serviceMethod() {

    }
	
	def getAllPositions(){
		
		Position.list()
	}
	
	def getAllRounds(){
		
		AssessmentRound.list()
	}
	
	def getAllInterviewers(){
		
		def query=User	
		List<User> interviewer = query.findAll()
		return interviewer
	}
	
	def getAllHiringProcesses(){
		
		HiringProcess.list()
	}
	
}
