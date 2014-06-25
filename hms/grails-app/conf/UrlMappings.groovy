class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"/view1"(view:"/partials/partial1")
		"/view2"(view:"/partials/partial2")
		"/view3"(view:"/partials/partial3")
		"500"(view:'/error')
	}
}
