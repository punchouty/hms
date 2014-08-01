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

hms.filter('renderAssessmentStatus', function(){
	return function(assessmentStatus){
		if(assessmentStatus=='0') return "UnScheduled";
		else if(assessmentStatus=='1') return "Scheduled";
		else if(assessmentStatus == '2') return "Interview In Progress";
		else if(assessmentStatus == '3') return "Reschedule";
		else if(assessmentStatus == '4') return "Cancel";
		else if(assessmentStatus == '5') return "New Round";
		else if(assessmentStatus == '6') return "Completed";
	}
});