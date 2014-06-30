
class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"/schedule"(view:"/partials/schedule")
		"/assessment"(view:"/partials/assessment")
		"/createwf"(view:"/partials/createwf")
		"500"(view:'/error')
	}
}

