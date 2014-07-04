
class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		
		"/"(view:"/index")
		"/schedule"(view:"/partials/schedule")
		"/scheduleRounds"(view:"/partials/scheduleRounds")
		"/assessment"(view:"/partials/assessment")
		"/configureWF"(view:"/partials/configureWF")
		"/createWF"(view:"/partials/createWF")
		"/dashboard"(view:"/partials/dashboard")
		"500"(view:'/error')
	}
}

