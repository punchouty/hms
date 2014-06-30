package com.sapient.hms.domain

import org.springframework.dao.DataIntegrityViolationException

class SkillBucketController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [skillBucketInstanceList: SkillBucket.list(params), skillBucketInstanceTotal: SkillBucket.count()]
    }

    def create() {
        [skillBucketInstance: new SkillBucket(params)]
    }

    def save() {
        def skillBucketInstance = new SkillBucket(params)
        if (!skillBucketInstance.save(flush: true)) {
            render(view: "create", model: [skillBucketInstance: skillBucketInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), skillBucketInstance.id])
        redirect(action: "show", id: skillBucketInstance.id)
    }

    def show(Long id) {
        def skillBucketInstance = SkillBucket.get(id)
        if (!skillBucketInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), id])
            redirect(action: "list")
            return
        }

        [skillBucketInstance: skillBucketInstance]
    }

    def edit(Long id) {
        def skillBucketInstance = SkillBucket.get(id)
        if (!skillBucketInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), id])
            redirect(action: "list")
            return
        }

        [skillBucketInstance: skillBucketInstance]
    }

    def update(Long id, Long version) {
        def skillBucketInstance = SkillBucket.get(id)
        if (!skillBucketInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (skillBucketInstance.version > version) {
                skillBucketInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'skillBucket.label', default: 'SkillBucket')] as Object[],
                          "Another user has updated this SkillBucket while you were editing")
                render(view: "edit", model: [skillBucketInstance: skillBucketInstance])
                return
            }
        }

        skillBucketInstance.properties = params

        if (!skillBucketInstance.save(flush: true)) {
            render(view: "edit", model: [skillBucketInstance: skillBucketInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), skillBucketInstance.id])
        redirect(action: "show", id: skillBucketInstance.id)
    }

    def delete(Long id) {
        def skillBucketInstance = SkillBucket.get(id)
        if (!skillBucketInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), id])
            redirect(action: "list")
            return
        }

        try {
            skillBucketInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'skillBucket.label', default: 'SkillBucket'), id])
            redirect(action: "show", id: id)
        }
    }
}
