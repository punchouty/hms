class SecurityFilters {
   def filters = {
	   secure(controller:"HiringController", action:"schedule") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:schedule")
			   }
		   }
		 }
	   
	   secure(controller:"HiringController", action:"delete") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:delete")
			   }
		   }
		 }
	   
	   secure(controller:"HiringController", action:"cancel") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:cancel")
			   }
		   }
		 }
	   
	   secure(controller:"HiringController", action:"reschedule") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:reschedule")
			   }
		   }
		 }
	   
	   secure(controller:"AssessmentController", action:"save") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:round:save:results")
			   }
		   }
		 }
	   
	   secure(controller:"AssessmentController", action:"requestReschedule") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:round:request:reschedule")
			   }
		   }
		 }
	   secure(controller:"AssessmentController", action:"requestCancel") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:round:request:cancel")
			   }
		   }
		 }
	   secure(controller:"AssessmentController", action:"markComplete") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:round:complete")
			   }
		   }
		 }
	   secure(controller:"AssessmentController", action:"markStart") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:round:start")
			   }
		   }
		 }
	   secure(controller:"AssessmentController", action:"requestAnotherRound") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:round:request")
			   }
		   }
		 }

	   secure(controller:"AssessmentController", action:"updateResults") {
		   before = {
			   accessControl {
				   role("HUMANRESOURCES") || permission("interview:round:update:results")
			   }
		   }
		 }
   }
}