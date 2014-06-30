package com.sapient.hms.domain

import org.springframework.dao.DataIntegrityViolationException

class AssessmentRoundController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [assessmentRoundInstanceList: AssessmentRound.list(params), assessmentRoundInstanceTotal: AssessmentRound.count()]
    }

    def create() {
        [assessmentRoundInstance: new AssessmentRound(params)]
    }

    def save() {
        def assessmentRoundInstance = new AssessmentRound(params)
        if (!assessmentRoundInstance.save(flush: true)) {
            render(view: "create", model: [assessmentRoundInstance: assessmentRoundInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), assessmentRoundInstance.id])
        redirect(action: "show", id: assessmentRoundInstance.id)
    }

    def show(Long id) {
        def assessmentRoundInstance = AssessmentRound.get(id)
        if (!assessmentRoundInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), id])
            redirect(action: "list")
            return
        }

        [assessmentRoundInstance: assessmentRoundInstance]
    }

    def edit(Long id) {
        def assessmentRoundInstance = AssessmentRound.get(id)
        if (!assessmentRoundInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), id])
            redirect(action: "list")
            return
        }

        [assessmentRoundInstance: assessmentRoundInstance]
    }

    def update(Long id, Long version) {
        def assessmentRoundInstance = AssessmentRound.get(id)
        if (!assessmentRoundInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (assessmentRoundInstance.version > version) {
                assessmentRoundInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'assessmentRound.label', default: 'AssessmentRound')] as Object[],
                          "Another user has updated this AssessmentRound while you were editing")
                render(view: "edit", model: [assessmentRoundInstance: assessmentRoundInstance])
                return
            }
        }

        assessmentRoundInstance.properties = params

        if (!assessmentRoundInstance.save(flush: true)) {
            render(view: "edit", model: [assessmentRoundInstance: assessmentRoundInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), assessmentRoundInstance.id])
        redirect(action: "show", id: assessmentRoundInstance.id)
    }

    def delete(Long id) {
        def assessmentRoundInstance = AssessmentRound.get(id)
        if (!assessmentRoundInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), id])
            redirect(action: "list")
            return
        }

        try {
            assessmentRoundInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'assessmentRound.label', default: 'AssessmentRound'), id])
            redirect(action: "show", id: id)
        }
    }
}
