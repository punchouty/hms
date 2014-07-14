package hms

import java.util.Date;
import java.util.List;

import com.sapient.hms.security.User;

class ScheduleRoundsBucketsVO {
	
	Long evaluationBucketId
	String bucketName
	Integer candidateBucketScore
	List<ScheduleRoundsSkillsVO>  skillEval
}
