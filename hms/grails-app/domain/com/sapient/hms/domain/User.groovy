package com.sapient.hms.domain

class User {

	int id
	Role role
	String name
	int expectedSkillRating
	String location
	String accountName
	String employeeId
	
	static hasMany=[roles:Role]
	
    static constraints = {
    }
}
