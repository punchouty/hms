modules = {
    application {
		dependsOn "angular, bootstrap"
		
        resource url:'js/application.js'
		resource url: 'js/angular/angular-route.min.js'
		resource url: 'js/angular/angular-resource.min.js'
		resource url: 'js/angular/angular-sanitize.min.js'
		resource url: 'js/angular/angular-cookies.min.js'
		resource url: 'http://getbootstrap.com/assets/js/docs.min.js'
		
		resource url:'js/hms/app.js'
		resource url:'js/hms/hiringService.js'
		resource url:'js/hms/hiringFilter.js'
		resource url:'js/hms/hiringController.js'

    }
}