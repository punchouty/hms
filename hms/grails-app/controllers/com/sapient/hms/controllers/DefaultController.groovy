package com.sapient.hms.controllers

import org.apache.shiro.SecurityUtils;

import com.sapient.hms.security.User;

class DefaultController {
	
	def index(){
		def user = User.get(SecurityUtils.getSubject()?.getPrincipal())
			render(view: "/index", model: [loggedInUserId: user?.id, loggedInUser: user?.username])
		
	}
	def schedule(){
		render view:"/partials/schedule"
	}
	def scheduleRounds(){
		render view:"/partials/scheduleRounds"
	}
	def configureWF(){
		render view:"/partials/configureWF"
	}
	def createWF(){
		render view:"/partials/createWF"
	}
	def assessmentRoundsList(){
		render view:"/partials/assessmentRoundsList"
	}
	def assessment(){
		render view:"/partials/assessment"
	}
	def dashboard(){
		render view:"/partials/dashboard"
	}

}
