package com.sapient.hms.domain

class Role {

	int id
	String name
	
	static  belongsTo = [user :User]
    static constraints = {
    }
}
