package com.sapient.hms.controllers

import grails.converters.JSON;

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.Position;

class PositionController {

    static allowedMethods = [index: "GET", save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
       def pos =  Position.list()
		render pos.collect{ [ id: it.id, name: it.name ] } as JSON
    }

    def create() {
        [positionInstance: new Position(params)]
    }

    def save() {
        def positionInstance = new Position(params)
        if (!positionInstance.save(flush: true)) {
            render(view: "create", model: [positionInstance: positionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'position.label', default: 'Position'), positionInstance.id])
        redirect(action: "show", id: positionInstance.id)
    }

    def show(Long id) {
        def positionInstance = Position.get(id)
        if (!positionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'position.label', default: 'Position'), id])
            redirect(action: "list")
            return
        }

        [positionInstance: positionInstance]
    }

    def edit(Long id) {
        def positionInstance = Position.get(id)
        if (!positionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'position.label', default: 'Position'), id])
            redirect(action: "list")
            return
        }

        [positionInstance: positionInstance]
    }

    def update(Long id, Long version) {
        def positionInstance = Position.get(id)
        if (!positionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'position.label', default: 'Position'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (positionInstance.version > version) {
                positionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'position.label', default: 'Position')] as Object[],
                          "Another user has updated this Position while you were editing")
                render(view: "edit", model: [positionInstance: positionInstance])
                return
            }
        }

        positionInstance.properties = params

        if (!positionInstance.save(flush: true)) {
            render(view: "edit", model: [positionInstance: positionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'position.label', default: 'Position'), positionInstance.id])
        redirect(action: "show", id: positionInstance.id)
    }

    def delete(Long id) {
        def positionInstance = Position.get(id)
        if (!positionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'position.label', default: 'Position'), id])
            redirect(action: "list")
            return
        }

        try {
            positionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'position.label', default: 'Position'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'position.label', default: 'Position'), id])
            redirect(action: "show", id: id)
        }
    }
}
