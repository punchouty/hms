package com.sapient.hms.controllers

class DefaultController {
	
	def index(){
		render view:"/index"
	}
	def schedule(){
		render view:"/partials/schedule"
	}
	def scheduleRounds(){
		render view:"/partials/scheduleRounds"
	}
	def assessment(){
		render view:"/partials/assessment"
	}
	def configureWF(){
		render view:"/partials/configureWF"
	}
	def createWF(){
		render view:"/partials/createWF"
	}
	def dashboard(){
		render view:"/partials/dashboard"
	}

}
