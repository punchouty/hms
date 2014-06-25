class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"/partial1"(view:"/partials/partial1")
		"/partial2"(view:"/partials/partial2")
		"/partial3"(view:"/partials/partial3")
		"500"(view:'/error')
	}
}
