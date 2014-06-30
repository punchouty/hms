package com.sapient.hms.controllers

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.RoundEvaluationResult;

class RoundEvaluationResultController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [roundEvaluationResultInstanceList: RoundEvaluationResult.list(params), roundEvaluationResultInstanceTotal: RoundEvaluationResult.count()]
    }

    def create() {
        [roundEvaluationResultInstance: new RoundEvaluationResult(params)]
    }

    def save() {
        def roundEvaluationResultInstance = new RoundEvaluationResult(params)
        if (!roundEvaluationResultInstance.save(flush: true)) {
            render(view: "create", model: [roundEvaluationResultInstance: roundEvaluationResultInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), roundEvaluationResultInstance.id])
        redirect(action: "show", id: roundEvaluationResultInstance.id)
    }

    def show(Long id) {
        def roundEvaluationResultInstance = RoundEvaluationResult.get(id)
        if (!roundEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        [roundEvaluationResultInstance: roundEvaluationResultInstance]
    }

    def edit(Long id) {
        def roundEvaluationResultInstance = RoundEvaluationResult.get(id)
        if (!roundEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        [roundEvaluationResultInstance: roundEvaluationResultInstance]
    }

    def update(Long id, Long version) {
        def roundEvaluationResultInstance = RoundEvaluationResult.get(id)
        if (!roundEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (roundEvaluationResultInstance.version > version) {
                roundEvaluationResultInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult')] as Object[],
                          "Another user has updated this RoundEvaluationResult while you were editing")
                render(view: "edit", model: [roundEvaluationResultInstance: roundEvaluationResultInstance])
                return
            }
        }

        roundEvaluationResultInstance.properties = params

        if (!roundEvaluationResultInstance.save(flush: true)) {
            render(view: "edit", model: [roundEvaluationResultInstance: roundEvaluationResultInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), roundEvaluationResultInstance.id])
        redirect(action: "show", id: roundEvaluationResultInstance.id)
    }

    def delete(Long id) {
        def roundEvaluationResultInstance = RoundEvaluationResult.get(id)
        if (!roundEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        try {
            roundEvaluationResultInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'roundEvaluationResult.label', default: 'RoundEvaluationResult'), id])
            redirect(action: "show", id: id)
        }
    }
}
