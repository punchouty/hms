package com.sapient.hms.controllers

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.BucketEvaluationResult;

class BucketEvaluationResultController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [bucketEvaluationResultInstanceList: BucketEvaluationResult.list(params), bucketEvaluationResultInstanceTotal: BucketEvaluationResult.count()]
    }

    def create() {
        [bucketEvaluationResultInstance: new BucketEvaluationResult(params)]
    }

    def save() {
        def bucketEvaluationResultInstance = new BucketEvaluationResult(params)
        if (!bucketEvaluationResultInstance.save(flush: true)) {
            render(view: "create", model: [bucketEvaluationResultInstance: bucketEvaluationResultInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), bucketEvaluationResultInstance.id])
        redirect(action: "show", id: bucketEvaluationResultInstance.id)
    }

    def show(Long id) {
        def bucketEvaluationResultInstance = BucketEvaluationResult.get(id)
        if (!bucketEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        [bucketEvaluationResultInstance: bucketEvaluationResultInstance]
    }

    def edit(Long id) {
        def bucketEvaluationResultInstance = BucketEvaluationResult.get(id)
        if (!bucketEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        [bucketEvaluationResultInstance: bucketEvaluationResultInstance]
    }

    def update(Long id, Long version) {
        def bucketEvaluationResultInstance = BucketEvaluationResult.get(id)
        if (!bucketEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (bucketEvaluationResultInstance.version > version) {
                bucketEvaluationResultInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult')] as Object[],
                          "Another user has updated this BucketEvaluationResult while you were editing")
                render(view: "edit", model: [bucketEvaluationResultInstance: bucketEvaluationResultInstance])
                return
            }
        }

        bucketEvaluationResultInstance.properties = params

        if (!bucketEvaluationResultInstance.save(flush: true)) {
            render(view: "edit", model: [bucketEvaluationResultInstance: bucketEvaluationResultInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), bucketEvaluationResultInstance.id])
        redirect(action: "show", id: bucketEvaluationResultInstance.id)
    }

    def delete(Long id) {
        def bucketEvaluationResultInstance = BucketEvaluationResult.get(id)
        if (!bucketEvaluationResultInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), id])
            redirect(action: "list")
            return
        }

        try {
            bucketEvaluationResultInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'bucketEvaluationResult.label', default: 'BucketEvaluationResult'), id])
            redirect(action: "show", id: id)
        }
    }
}
