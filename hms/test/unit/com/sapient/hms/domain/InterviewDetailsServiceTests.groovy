
package com.sapient.hms.domain

import grails.test.mixin.*

import org.junit.*

import com.sapient.hms.service.InterviewDetailsService;

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(InterviewDetailsService)
class InterviewDetailsServiceTests {
	
	//def interviewDetailsService
	void testSample(){
	
		assertEquals(service.getAllInterviewers(), 0)
		
		
	}

    
}
