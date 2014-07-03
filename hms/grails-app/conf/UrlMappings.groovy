
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
		"/createwf"(view:"/partials/createwf")
		"500"(view:'/error')
	}
}

