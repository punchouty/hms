package hms

import java.util.Date;
import java.util.List;

import com.sapient.hms.security.User;

class ScheduleRoundsBucketsVO {
	
	Long evaluationBucketId
	String roundName
	Long interviewerId
	String interviewerName
	Date interviewTime
	List<ScheduleRoundsSkillsVO>  skillEval
}