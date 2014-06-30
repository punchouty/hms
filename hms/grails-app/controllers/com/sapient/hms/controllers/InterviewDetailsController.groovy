package com.sapient.hms.controllers

import grails.converters.JSON
import com.sapient.hms.security.User

class InterviewDetailsController {
	
	
	def interviewDetailsService
		
	
	def getPositions(Integer max) {
		def positions = interviewDetailsService.allPositions()
		render positions as JSON
	}
	
	def getInterviewers(){
		
		List<User> interviwers=interviewDetailsService.allInterviewers();
		render interviwers as JSON
	}
	
	def getRounds(){
		
		def rounds=interviewDetailsService.allRounds()
		render rounds as JSON
	}
	
	def getHiringProcess(){
		
		def hiringProcess=interviewDetailsService.allHiringProcesses()
		render hiringProcess as JSON
	}

    def index() { }
}
