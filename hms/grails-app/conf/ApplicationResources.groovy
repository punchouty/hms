modules = {
    core {
	
        resource url:'js/application.js'
    }
	
	jqr {
		resource url: 'lib/bower_components/jquery/dist/jquery.min.js'
	}
	
	ang {
		resource url:'lib/bower_components/angular/angular.min.js'
		//resource url:'lib/bower_components/angular/angular.min.js.map'
		resource url: 'lib/bower_components/angular-route/angular-route.min.js'
		resource url: 'lib/bower_components/angular-resource/angular-resource.min.js'
		resource url: 'lib/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js'
	}
	
	btr {
		dependsOn 'jqr'
		resource url: 'lib/bower_components/bootstrap/dist/js/bootstrap.min.js'
		
	}
	
			
	application {
		resource url: 'http://getbootstrap.com/assets/js/docs.min.js'
		resource url:'js/hms/app.js'
		resource url:'js/hms/hiringService.js'
		resource url:'js/hms/hiringFilter.js'
		resource url:'js/hms/hiringController.js'
		resource url:'js/hms/hiringRoundController.js'
		resource url:'js/hms/assessmentRoundController.js'
		resource url:'js/hms/hiringAssessRoundController.js'
    }
}