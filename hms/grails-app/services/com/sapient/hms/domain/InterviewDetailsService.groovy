package com.sapient.hms.domain

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
		
		def query=User.where{role==0}	
		List<User> interviewer = query.findAll()
		return interviewer
	}
	
	def getAllHiringProcesses(){
		
		HiringProcess.list()
	}
	
}
