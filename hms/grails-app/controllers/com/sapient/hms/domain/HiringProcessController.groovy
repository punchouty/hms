package com.sapient.hms.domain

import org.springframework.dao.DataIntegrityViolationException

class HiringProcessController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [hiringProcessInstanceList: HiringProcess.list(params), hiringProcessInstanceTotal: HiringProcess.count()]
    }

    def create() {
        [hiringProcessInstance: new HiringProcess(params)]
    }

    def save() {
        def hiringProcessInstance = new HiringProcess(params)
        if (!hiringProcessInstance.save(flush: true)) {
            render(view: "create", model: [hiringProcessInstance: hiringProcessInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), hiringProcessInstance.id])
        redirect(action: "show", id: hiringProcessInstance.id)
    }

    def show(Long id) {
        def hiringProcessInstance = HiringProcess.get(id)
        if (!hiringProcessInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), id])
            redirect(action: "list")
            return
        }

        [hiringProcessInstance: hiringProcessInstance]
    }

    def edit(Long id) {
        def hiringProcessInstance = HiringProcess.get(id)
        if (!hiringProcessInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), id])
            redirect(action: "list")
            return
        }

        [hiringProcessInstance: hiringProcessInstance]
    }

    def update(Long id, Long version) {
        def hiringProcessInstance = HiringProcess.get(id)
        if (!hiringProcessInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (hiringProcessInstance.version > version) {
                hiringProcessInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'hiringProcess.label', default: 'HiringProcess')] as Object[],
                          "Another user has updated this HiringProcess while you were editing")
                render(view: "edit", model: [hiringProcessInstance: hiringProcessInstance])
                return
            }
        }

        hiringProcessInstance.properties = params

        if (!hiringProcessInstance.save(flush: true)) {
            render(view: "edit", model: [hiringProcessInstance: hiringProcessInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), hiringProcessInstance.id])
        redirect(action: "show", id: hiringProcessInstance.id)
    }

    def delete(Long id) {
        def hiringProcessInstance = HiringProcess.get(id)
        if (!hiringProcessInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), id])
            redirect(action: "list")
            return
        }

        try {
            hiringProcessInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'hiringProcess.label', default: 'HiringProcess'), id])
            redirect(action: "show", id: id)
        }
    }
}
