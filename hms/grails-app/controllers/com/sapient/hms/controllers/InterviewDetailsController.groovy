package com.sapient.hms.controllers

import grails.converters.JSON
import groovy.json.JsonSlurper;

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
		//JSON.use("deep")
        render InterviewDetail.list(params) as JSON
    }

    def create() {
        [interviewDetailsInstance: new InterviewDetail(params)]
    }

    def save() {
		def result = JSON.parse(request.JSON.toString());
        def interviewDetailsInstance = new InterviewDetail(result)
		interviewDetailsInstance.candidateDetail = CandidateDetail.get(result.candidateDetail.id)
		interviewDetailsInstance.position = Position.get(result.position.id)
		interviewDetailsInstance.hiringperson = User.get(result.hiringperson.id)
		interviewDetailsInstance.hiringProcess = HiringProcess.get(result.hiringProcess.id)
		//populateDetails(interviewDetailsInstance)
        if (!interviewDetailsInstance.save(flush: true)) {
			interviewDetailsInstance.errors.rejectValue('interviewDetailsInstance','default.failure')
        }
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
				def skilDef = it.skills
				skilDef.each(){
					SkillEvaluation skillEval = new SkillEvaluation()
					skillEval.skill = it
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
            render interviewDetailsInstance as JSON
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "show", id: id)
        }
    }
	
	
}
