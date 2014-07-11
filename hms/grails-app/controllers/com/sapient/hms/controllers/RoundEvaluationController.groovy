package com.sapient.hms.controllers

import org.hibernate.FetchMode as FM
import grails.converters.JSON
import hms.InterviewDetailsVO
import hms.ScheduleRoundsBucketsVO
import hms.ScheduleRoundsSkillsVO
import hms.ScheduleRoundsVO

import com.sapient.hms.domain.InterviewDetail
import com.sapient.hms.domain.RoundEvaluation

class RoundEvaluationController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}
	//
	//    def list(Integer max) {
	//        params.max = Math.min(max ?: 10, 100)
	//        [roundEvaluationResultInstanceList: RoundEvaluation.list(params), roundEvaluationResultInstanceTotal: RoundEvaluation.count()]
	//    }

	def listByInterview(Long id) {
		
//		def roundEvalsQuery = RoundEvaluation.withCriteria {
//			eq "interviewDetail.id", id
//			fetchMode "bucketEvaluations", FM.SELECT
//		}
		
		
		def roundEvalsQuery = RoundEvaluation.where{
			interviewDetail.id== id
		}
		.withPopulatedQuery(null, null) { query ->
			query.@criteria.setFetchMode('bucketEvaluations', FM.EAGER)
			query.@criteria.setFetchMode('bucketEvaluations.skillEvaluations', FM.EAGER)
			//query.list()
			}
		def roundEvals=roundEvalsQuery.list()
		def roundEvalsList = new ArrayList<ScheduleRoundsVO>()
		roundEvals.each{ 
			def roundVO = new ScheduleRoundsVO()
			roundVO.evaluationRoundId = it.id
			roundVO.roundName = it.assessmentRound.name
			if(it.interviewer)
			{
			roundVO.interviewerId = it.interviewer.id
			roundVO.interviewerName = it.interviewer.username
			roundVO.interviewTime = it.scheduledTime
			}
			
			def bucketEvals = it.bucketEvaluations
			bucketEvals.each{}
			bucketEvals = it.bucketEvaluations
			def bucketEvalsList = new ArrayList<ScheduleRoundsBucketsVO>()
			bucketEvals.each{
				def bucketVO = new ScheduleRoundsBucketsVO()
				bucketVO.evaluationBucketId = it.id
				bucketVO.bucketName = it.skillBucket.name
				def skillEvals = it.skillEvaluations
				skillEvals.each{}
				def skillEvalsList = new ArrayList<ScheduleRoundsSkillsVO>()
				skillEvals.each{
					def skillVO = new ScheduleRoundsSkillsVO()
					skillVO.evaluationSkillId = it.id
					skillVO.skillName = it.skillItem.name
					skillVO.cutOffScore =it.skillItem.cutOffScore
					skillVO.weight = it.skillItem.weight
					skillVO.expectedSkillrating = it.skillItem.expectedSkillrating
					skillVO.candidaterating = it.candidateRating
					skillVO.candidateScore = it.candidateSkillScore
					skillEvalsList.add(skillVO)
				}
				bucketVO.skillEval  = skillEvalsList
				bucketEvalsList.add(bucketVO)
			}
			roundVO.bucketEval = bucketEvalsList
			roundEvalsList.add(roundVO)
		}
		render roundEvalsList as JSON
	}

	
	
//	def searchByInterview (Long id){
//             // def roundEvaluation=RoundEvaluation.findAllByInterviewer(interviewerId);
//              println id
//			   def interviewDetailsList = new ArrayList<InterviewDetailsVO>()
//			   def roundEvaluation=RoundEvaluation.createCriteria();
//			   def results=roundEvaluation.list {
//					  and{
//							eq("interviewer.id",id)
//					  }
//					 // order("scheduledTime",desc)
//			   }
//			   results.each {
//					  def interviewDetailVO = new InterviewDetailsVO();
//					  interviewDetailVO.candidateName=it.interviewDetail.candidateDetail.name
//															   interviewDetailVO.roundName=it.assessmentRound.name
//															   interviewDetailVO.interviewMode=it.interviewDetail.interviewMode
//															   interviewDetailVO.scheduledDate=it.scheduledTime
//															   interviewDetailVO.interviewer=it.interviewer.name
//															   interviewDetailsList.add(interviewDetailVO)
//			   }
// 
//			   render interviewDetailsList as JSON
//			   
//      }

	
	def update(long roundId,String newStatus){
		def interviewDetail=InterviewDetail.where {
			roundEvaluations.id==roundId
		}		
		interviewDetail.updateAll(completionStatus:newStatus)		
	}

	//    def create() {
	//        [roundEvaluationResultInstance: new RoundEvaluation(params)]
	//    }
	//
	//    def save() {
	//        def roundEvaluationResultInstance = new RoundEvaluation(params)
	//        if (!roundEvaluationResultInstance.save(flush: true)) {
	//            render(view: "create", model: [roundEvaluationResultInstance: roundEvaluationResultInstance])
	//            return
	//        }
	//
	//        flash.message = message(code: 'default.created.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), roundEvaluationResultInstance.id])
	//        redirect(action: "show", id: roundEvaluationResultInstance.id)
	//    }
	//
	    def show(Long id) {
	        def roundEvaluationResultInstance = RoundEvaluation.get(id)
	
	    }
	//
	//    def edit(Long id) {
	//        def roundEvaluationResultInstance = RoundEvaluation.get(id)
	//        if (!roundEvaluationResultInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        [roundEvaluationResultInstance: roundEvaluationResultInstance]
	//    }
	//
	//    def update(Long id, Long version) {
	//        def roundEvaluationResultInstance = RoundEvaluation.get(id)
	//        if (!roundEvaluationResultInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        if (version != null) {
	//            if (roundEvaluationResultInstance.version > version) {
	//                roundEvaluationResultInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
	//                          [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult')] as Object[],
	//                          "Another user has updated this RoundEvaluationResult while you were editing")
	//                render(view: "edit", model: [roundEvaluationResultInstance: roundEvaluationResultInstance])
	//                return
	//            }
	//        }
	//
	//        roundEvaluationResultInstance.properties = params
	//
	//        if (!roundEvaluationResultInstance.save(flush: true)) {
	//            render(view: "edit", model: [roundEvaluationResultInstance: roundEvaluationResultInstance])
	//            return
	//        }
	//
	//        flash.message = message(code: 'default.updated.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), roundEvaluationResultInstance.id])
	//        redirect(action: "show", id: roundEvaluationResultInstance.id)
	//    }
	//
	//    def delete(Long id) {
	//        def roundEvaluationResultInstance = RoundEvaluation.get(id)
	//        if (!roundEvaluationResultInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        try {
	//            roundEvaluationResultInstance.delete(flush: true)
	//            flash.message = message(code: 'default.deleted.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
	//            redirect(action: "list")
	//        }
	//        catch (DataIntegrityViolationException e) {
	//            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
	//            redirect(action: "show", id: id)
	//        }
	//    }
}
