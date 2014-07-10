package com.sapient.hms.controllers

import grails.converters.JSON
import hms.InterviewDetailsVO
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
		def interviewDetail = InterviewDetail.get(id)
		def roundEvals = RoundEvaluation.findAllByInterviewDetail(interviewDetail)
		def roundEvalsList = new ArrayList<ScheduleRoundsVO>()
		roundEvals.each{
			def roundEvalItem = new ScheduleRoundsVO()
			//roundEvalItem.evaluationRoundId = it.id
			roundEvalItem.roundName = it.assessmentRound.name
			//roundEvalItem.interviewerId = it.interviewer.id
			//roundEvalItem.interviewerName = it.interviewer.username
			roundEvalItem.interviewTime = it.scheduledTime
			//def skillsEvals = it.
			//def bucketEvalsList = new ArrayList<ScheduleRoundsBucketsVO>()
			roundEvalsList.add(roundEvalItem)			
		}
		render roundEvalsList as JSON
	}

	def searchByInterview (Long id){
             // def roundEvaluation=RoundEvaluation.findAllByInterviewer(interviewerId);
              println id
			   def interviewDetailsList = new ArrayList<InterviewDetailsVO>()
			   def roundEvaluation=RoundEvaluation.createCriteria();
			   def results=roundEvaluation.list {
					  and{
							eq("interviewer.id",id)
					  }
					 // order("scheduledTime",desc)
			   }
			   results.each {
					  def interviewDetailVO = new InterviewDetailsVO();
					  interviewDetailVO.candidateName=it.interviewDetail.candidateDetail.name
															   interviewDetailVO.roundName=it.assessmentRound.name
															   interviewDetailVO.interviewMode=it.interviewDetail.interviewMode
															   interviewDetailVO.scheduledDate=it.scheduledTime
															   interviewDetailVO.interviewer=it.interviewer.name
															   interviewDetailsList.add(interviewDetailVO)
			   }
 
			   render interviewDetailsList as JSON
			   
      }

	
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
	//    def show(Long id) {
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
