package com.sapient.hms.controllers

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.SkillEvaluation;
import grails.converters.JSON

class SkillEvaluationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [skillEvaluationresultInstanceList: SkillEvaluation.list(params), skillEvaluationresultInstanceTotal: SkillEvaluation.count()]
    }

    def create() {
        [skillEvaluationresultInstance: new SkillEvaluation(params)]
    }

    def save() {
        def skillEvaluationresultInstance = new SkillEvaluation(params)
        if (!skillEvaluationresultInstance.save(flush: true)) {
            render(view: "create", model: [skillEvaluationresultInstance: skillEvaluationresultInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), skillEvaluationresultInstance.id])
        redirect(action: "show", id: skillEvaluationresultInstance.id)
    }

    def show(Long id) {
        def skillEvaluationresultInstance = SkillEvaluation.get(id)
        if (!skillEvaluationresultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "list")
            return
        }

        [skillEvaluationresultInstance: skillEvaluationresultInstance]
    }

    def edit(Long id) {
        def skillEvaluationresultInstance = SkillEvaluation.get(id)
        if (!skillEvaluationresultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "list")
            return
        }

        [skillEvaluationresultInstance: skillEvaluationresultInstance]
    }

/*    def update(Long id, Long version) {
        def skillEvaluationresultInstance = SkillEvaluation.get(id)
        if (!skillEvaluationresultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (skillEvaluationresultInstance.version > version) {
                skillEvaluationresultInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult')] as Object[],
                          "Another user has updated this SkillEvaluationresult while you were editing")
                render(view: "edit", model: [skillEvaluationresultInstance: skillEvaluationresultInstance])
                return
            }
        }

        skillEvaluationresultInstance.properties = params

        if (!skillEvaluationresultInstance.save(flush: true)) {
            render(view: "edit", model: [skillEvaluationresultInstance: skillEvaluationresultInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), skillEvaluationresultInstance.id])
        redirect(action: "show", id: skillEvaluationresultInstance.id)
    }*/
	
	def update(){
		print 'update function'
		
		def result = JSON.parse(request.JSON.toString());
		print result.evaluationSkillId
		def skillEval = SkillEvaluation.get(result.evaluationSkillId)
		skillEval.candidateRating = result.candidateRating
		skillEval.candidateSkillScore = result.candidateScore
		skillEval.feedback = result.feedback
		skillEval.save(flush:true)
		render skillEval as JSON
	}

    def delete(Long id) {
        def skillEvaluationresultInstance = SkillEvaluation.get(id)
        if (!skillEvaluationresultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "list")
            return
        }

        try {
            skillEvaluationresultInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "show", id: id)
        }
    }
}
