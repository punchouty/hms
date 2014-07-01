hms.filter('renderStatus', function(){
	return function(completionStatus){
		if(completionStatus=='0') return "Not Scheduled";
		else
			return "Scheduled";;
	}
});