class SecurityFilters {
   def filters = {
	   
	   
	   scheduleInterviewScreen(controller:"default", action:"schedule|scheduleRounds|dashboard|index") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES")
			   }
		   }
		 }
	   
	   
	   adminScreen(controller:"default", action:"createWF|configureWF") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES")
			   }
		   }
		 }
	   
	   interviewerScreen(controller:"default", action:"assessment") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES")
			   }
		   }
		 }
	   
	   getPosition(controller:"position", action:"index|list") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES")
			   }
		   }
		 }
	   
	   hiringProcess(controller:"hiringProcess", action:"listByPosition") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") 
			   }
		   }
		 }
	   
	   assessment(controller:"assessmentRound", action:"index|list") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") 
			   }
		   }
		 }
	   
	   candidate(controller:"candidateDetails", action:"index|list|save") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") 
			   }
		   }
		 }
	   
	   roundEval(controller:"roundEvaluation", action:"listByInterview") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES")
			   }
		   }
		 }
	   
	  	   
	   interview(controller:"interviewDetails", action:"listByUser|save|delete") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") 
			   }
		   }
		 }
	  
	   
   }
}