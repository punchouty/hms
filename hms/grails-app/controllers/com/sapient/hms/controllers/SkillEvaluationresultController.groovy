package com.sapient.hms.controllers

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.SkillEvaluationresult;

class SkillEvaluationresultController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [skillEvaluationresultInstanceList: SkillEvaluationresult.list(params), skillEvaluationresultInstanceTotal: SkillEvaluationresult.count()]
    }

    def create() {
        [skillEvaluationresultInstance: new SkillEvaluationresult(params)]
    }

    def save() {
        def skillEvaluationresultInstance = new SkillEvaluationresult(params)
        if (!skillEvaluationresultInstance.save(flush: true)) {
            render(view: "create", model: [skillEvaluationresultInstance: skillEvaluationresultInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), skillEvaluationresultInstance.id])
        redirect(action: "show", id: skillEvaluationresultInstance.id)
    }

    def show(Long id) {
        def skillEvaluationresultInstance = SkillEvaluationresult.get(id)
        if (!skillEvaluationresultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "list")
            return
        }

        [skillEvaluationresultInstance: skillEvaluationresultInstance]
    }

    def edit(Long id) {
        def skillEvaluationresultInstance = SkillEvaluationresult.get(id)
        if (!skillEvaluationresultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillEvaluationresult.label', default: 'SkillEvaluationresult'), id])
            redirect(action: "list")
            return
        }

        [skillEvaluationresultInstance: skillEvaluationresultInstance]
    }

    def update(Long id, Long version) {
        def skillEvaluationresultInstance = SkillEvaluationresult.get(id)
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
    }

    def delete(Long id) {
        def skillEvaluationresultInstance = SkillEvaluationresult.get(id)
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
