package com.sapient.hms.controllers

import org.apache.shiro.SecurityUtils;

import com.sapient.hms.security.User;
import grails.converters.JSON

class UserController {
	
	def listPanelUsers() {
		
		def users = User.findAll()
		render users as JSON
		
	}
	

}
