hms.filter('renderStatus', function(){
	return function(completionStatus){
		if(completionStatus=='0') return "Not Scheduled";
		else
			return "Scheduled";;
	}
});
hms.filter('renderMode', function(){
	return function(interviewMode){
		if(interviewMode=='T') return "Telephonic";
		else
			return "Face-To-Face";
			
	}
});