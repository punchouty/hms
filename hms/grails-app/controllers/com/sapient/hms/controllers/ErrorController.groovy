package com.sapient.hms.controllers

class ErrorController {

   
	
	def forbidden(){
		render view:"/error/forbidden"
	}
	def notFound(){
		render view:"/error/notFound"
	}
	def internalError(){
		render view:"/error/internalError"
	}
}
