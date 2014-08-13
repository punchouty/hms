package com.sapient.hms.controllers

import java.util.Date;

import grails.converters.JSON
import groovy.json.JsonSlurper;
import hms.InterviewDetailsVO

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.AssessmentRound;
import com.sapient.hms.domain.BucketEvaluation;
import com.sapient.hms.domain.CandidateDetail
import com.sapient.hms.domain.HiringProcess
import com.sapient.hms.domain.InterviewDetail
import com.sapient.hms.domain.Position
import com.sapient.hms.domain.RoundEvaluation;
import com.sapient.hms.domain.SkillEvaluation;
import com.sapient.hms.security.User

class InterviewDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

	 def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render InterviewDetail.list(params) as JSON
    }
	
    def listByUser(Long id) {
		
		def user = User.get(id)
		def interviewDetails = InterviewDetail.findAllByHiringperson(user)
		def interviewDetailsList = new ArrayList<InterviewDetailsVO>()
		interviewDetails.each {
			def interviewDetailVO = new InterviewDetailsVO()
			interviewDetailVO.interviewId = it.id
			interviewDetailVO.interviewMode = it.interviewMode
			interviewDetailVO.completionStatus = it.completionStatus
			interviewDetailVO.dateCreated = it.dateCreated
			interviewDetailVO.hiringProcessName = it.hiringProcess.name
			interviewDetailVO.positionName  = it.position.name
			interviewDetailVO.candidateName = it.candidateDetail.name
			interviewDetailVO.candidateId = it.candidateDetail.id
			interviewDetailsList.add(interviewDetailVO)
		}
		
        render interviewDetailsList as JSON
    }

    def create() {
        [interviewDetailsInstance: new InterviewDetail(params)]
    }

    def save() {
		def result = JSON.parse(request.JSON.toString());
        def interviewDetailsInstance = new InterviewDetail(result)
		println interviewDetailsInstance
		interviewDetailsInstance.candidateDetail = CandidateDetail.get(result.candidateDetail.id)
		interviewDetailsInstance.position = Position.get(result.position.id)
		interviewDetailsInstance.hiringperson = User.get(result.hiringperson.id)
		interviewDetailsInstance.hiringProcess = HiringProcess.get(result.hiringProcess.id)
		populateDetails(interviewDetailsInstance)
		boolean flag=interviewDetailsInstance.save(flush: true)
        if (flag==false||flag==null) {
			def errorMessage = [error : "error occured,please try again"]
			render errorMessage as JSON
			return			
		}
		println interviewDetailsInstance
		println flag
		render interviewDetailsInstance as JSON
    }

	def populateDetails(InterviewDetail interviewDetailsInstance){
		def processRounds = interviewDetailsInstance.hiringProcess.assessmentRounds
		processRounds.each() {
			def roundEval = new RoundEvaluation()
			roundEval.assessmentRound = it
			def skillBucketsDef = it.skillBuckets
			skillBucketsDef.each(){
				BucketEvaluation bucketEval = new BucketEvaluation()
				bucketEval.skillBucket = it
				def skilDef = it.skillItems
				skilDef.each(){
					SkillEvaluation skillEval = new SkillEvaluation()
					skillEval.skillItem = it
					bucketEval.addToSkillEvaluations(skillEval)
				}
				roundEval.addToBucketEvaluations(bucketEval)
			}
			interviewDetailsInstance.addToRoundEvaluations(roundEval)
		}
	}
    def show(Long id) {
        def interviewDetailsInstance = InterviewDetail.get(id)
        if (!interviewDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
            return
        }

        [interviewDetailsInstance: interviewDetailsInstance]
    }

    def edit(Long id) {
        def interviewDetailsInstance = InterviewDetail.get(id)
        if (!interviewDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
            return
        }

        [interviewDetailsInstance: interviewDetailsInstance]
    }

    def update(Long id, Long version) {
        def interviewDetailsInstance = InterviewDetail.get(id)
        if (!interviewDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (interviewDetailsInstance.version > version) {
                interviewDetailsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'interviewDetails.label', default: 'InterviewDetails')] as Object[],
                          "Another user has updated this InterviewDetails while you were editing")
                render(view: "edit", model: [interviewDetailsInstance: interviewDetailsInstance])
                return
            }
        }

        interviewDetailsInstance.properties = params

        if (!interviewDetailsInstance.save(flush: true)) {
            render(view: "edit", model: [interviewDetailsInstance: interviewDetailsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), interviewDetailsInstance.id])
        redirect(action: "show", id: interviewDetailsInstance.id)
    }

    def delete(Long id) {
        def interviewDetailsInstance = InterviewDetail.get(id)
        if (!interviewDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
            return
        }

        try {
            interviewDetailsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
			print interviewDetailsInstance as JSON
            render interviewDetailsInstance as JSON
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "show", id: id)
        }
    }
	
	
}
