package hms

import java.util.Date;
import java.util.List;

import com.sapient.hms.security.User;

class ScheduleRoundsVO {
	
	Long evaluationRoundId
	String roundName
	Long interviewerId
	Long assessmentRoundSequence
	String interviewerName
	Date interviewTime
	String interviewMode
	Integer candidateRoundScore
	String assessmentStatus
	Boolean isDisabled
	List<ScheduleRoundsBucketsVO>  bucketEval
	
}

