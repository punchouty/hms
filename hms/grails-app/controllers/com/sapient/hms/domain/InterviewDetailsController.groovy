package com.sapient.hms.domain

import org.springframework.dao.DataIntegrityViolationException

class InterviewDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [interviewDetailsInstanceList: InterviewDetails.list(params), interviewDetailsInstanceTotal: InterviewDetails.count()]
    }

    def create() {
        [interviewDetailsInstance: new InterviewDetails(params)]
    }

    def save() {
        def interviewDetailsInstance = new InterviewDetails(params)
        if (!interviewDetailsInstance.save(flush: true)) {
            render(view: "create", model: [interviewDetailsInstance: interviewDetailsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), interviewDetailsInstance.id])
        redirect(action: "show", id: interviewDetailsInstance.id)
    }

    def show(Long id) {
        def interviewDetailsInstance = InterviewDetails.get(id)
        if (!interviewDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
            return
        }

        [interviewDetailsInstance: interviewDetailsInstance]
    }

    def edit(Long id) {
        def interviewDetailsInstance = InterviewDetails.get(id)
        if (!interviewDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
            return
        }

        [interviewDetailsInstance: interviewDetailsInstance]
    }

    def update(Long id, Long version) {
        def interviewDetailsInstance = InterviewDetails.get(id)
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
        def interviewDetailsInstance = InterviewDetails.get(id)
        if (!interviewDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
            return
        }

        try {
            interviewDetailsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "show", id: id)
        }
    }
}
