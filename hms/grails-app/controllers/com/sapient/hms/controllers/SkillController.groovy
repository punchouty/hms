package com.sapient.hms.controllers

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.SkillItem;

class SkillController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [skillInstanceList: SkillItem.list(params), skillInstanceTotal: SkillItem.count()]
    }

    def create() {
        [skillInstance: new SkillItem(params)]
    }

    def save() {
        def skillInstance = new SkillItem(params)
        if (!skillInstance.save(flush: true)) {
            render(view: "create", model: [skillInstance: skillInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'skill.label', default: 'Skill'), skillInstance.id])
        redirect(action: "show", id: skillInstance.id)
    }

    def show(Long id) {
        def skillInstance = SkillItem.get(id)
        if (!skillInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skill.label', default: 'Skill'), id])
            redirect(action: "list")
            return
        }

        [skillInstance: skillInstance]
    }

    def edit(Long id) {
        def skillInstance = SkillItem.get(id)
        if (!skillInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skill.label', default: 'Skill'), id])
            redirect(action: "list")
            return
        }

        [skillInstance: skillInstance]
    }

    def update(Long id, Long version) {
        def skillInstance = SkillItem.get(id)
        if (!skillInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skill.label', default: 'Skill'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (skillInstance.version > version) {
                skillInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'skill.label', default: 'Skill')] as Object[],
                          "Another user has updated this Skill while you were editing")
                render(view: "edit", model: [skillInstance: skillInstance])
                return
            }
        }

        skillInstance.properties = params

        if (!skillInstance.save(flush: true)) {
            render(view: "edit", model: [skillInstance: skillInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'skill.label', default: 'Skill'), skillInstance.id])
        redirect(action: "show", id: skillInstance.id)
    }

    def delete(Long id) {
        def skillInstance = SkillItem.get(id)
        if (!skillInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skill.label', default: 'Skill'), id])
            redirect(action: "list")
            return
        }

        try {
            skillInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'skill.label', default: 'Skill'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'skill.label', default: 'Skill'), id])
            redirect(action: "show", id: id)
        }
    }
}
