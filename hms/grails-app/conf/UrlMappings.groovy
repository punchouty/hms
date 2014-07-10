
class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		
		"/"(controller: "default", action:"index")
		"/schedule"(controller: "default", action:"schedule")
		"/scheduleRounds"(controller: "default", action:"scheduleRounds")
		"/assessment"(controller: "default", action:"assessment")
		"/assessmentRoundsList"(controller: "default", action:"assessmentRoundsList")
		"/configureWF"(controller: "default", action:"configureWF")
		"/createWF"(controller: "default", action:"createWF")
		"/dashboard"(controller: "default", action:"dashboard")
		"500"(view:"/error")
	}
}

