class SecurityFilters {
   def filters = {
	   
	  common(controller:"default", action:"dashboard|index") {
		   before = {
			   accessControl { true   }
		   }
		 }
	   
	   scheduleInterviewScreen(controller:"default", action:"schedule|scheduleRounds") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES")
			   }
		   }
		 }
	   
	 	
	   adminScreen(controller:"default", action:"createWF|configureWF") {
		   before = {
			   accessControl {
				   role("SYSTEM ADMINISTRATOR")
			   }
		   }
		 }
	   
	   interviewerScreen(controller:"default", action:"assessment|assessmentRoundsList") {
		   before = {
			   accessControl {
				   role("PANEL")
			   }
		   }
		 }
	   
	   getPosition(controller:"position", action:"index|list") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || role("PANEL")
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
				   role("PANEL") 
			   }
		   }
		 }
	   
	   candidate(controller:"candidateDetails", action:"index|list|save") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") ||  role("PANEL") 
			   }
		   }
		 }
	   
	   roundEval(controller:"roundEvaluation", action:"listByInterview") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || role("PANEL")
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