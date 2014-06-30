package com.sapient.hms.domain

import org.springframework.dao.DataIntegrityViolationException

class CandidateDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [candidateDetailsInstanceList: CandidateDetails.list(params), candidateDetailsInstanceTotal: CandidateDetails.count()]
    }

    def create() {
        [candidateDetailsInstance: new CandidateDetails(params)]
    }

    def save() {
        def candidateDetailsInstance = new CandidateDetails(params)
        if (!candidateDetailsInstance.save(flush: true)) {
            render(view: "create", model: [candidateDetailsInstance: candidateDetailsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), candidateDetailsInstance.id])
        redirect(action: "show", id: candidateDetailsInstance.id)
    }

    def show(Long id) {
        def candidateDetailsInstance = CandidateDetails.get(id)
        if (!candidateDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
            redirect(action: "list")
            return
        }

        [candidateDetailsInstance: candidateDetailsInstance]
    }

    def edit(Long id) {
        def candidateDetailsInstance = CandidateDetails.get(id)
        if (!candidateDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
            redirect(action: "list")
            return
        }

        [candidateDetailsInstance: candidateDetailsInstance]
    }

    def update(Long id, Long version) {
        def candidateDetailsInstance = CandidateDetails.get(id)
        if (!candidateDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (candidateDetailsInstance.version > version) {
                candidateDetailsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'candidateDetails.label', default: 'CandidateDetails')] as Object[],
                          "Another user has updated this CandidateDetails while you were editing")
                render(view: "edit", model: [candidateDetailsInstance: candidateDetailsInstance])
                return
            }
        }

        candidateDetailsInstance.properties = params

        if (!candidateDetailsInstance.save(flush: true)) {
            render(view: "edit", model: [candidateDetailsInstance: candidateDetailsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), candidateDetailsInstance.id])
        redirect(action: "show", id: candidateDetailsInstance.id)
    }

    def delete(Long id) {
        def candidateDetailsInstance = CandidateDetails.get(id)
        if (!candidateDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
            redirect(action: "list")
            return
        }

        try {
            candidateDetailsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
            redirect(action: "show", id: id)
        }
    }
}
