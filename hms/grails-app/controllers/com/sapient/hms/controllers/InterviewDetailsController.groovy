package com.sapient.hms.controllers

import grails.converters.JSON;
import groovy.json.JsonBuilder;
import groovy.json.JsonSlurper

import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.CandidateDetails;
import com.sapient.hms.domain.HiringProcess;
import com.sapient.hms.domain.InterviewDetails;
import com.sapient.hms.domain.Position;
import com.sapient.hms.security.User;

class InterviewDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		JSON.use("deep")
       render InterviewDetails.list(params) as JSON
    }

    def create() {
        [interviewDetailsInstance: new InterviewDetails(params)]
    }

    def save() {
		def result = JSON.parse(request.JSON.toString());
        def interviewDetailsInstance = new InterviewDetails(result)
		interviewDetailsInstance.candidate = CandidateDetails.get(result.candidate.id)
		interviewDetailsInstance.position = Position.get(result.position.id)
		interviewDetailsInstance.hiringperson = User.get(result.hiringperson.id)
		interviewDetailsInstance.hiringProcess = HiringProcess.get(result.hiringProcess.id)
        if (!interviewDetailsInstance.save(flush: true)) {
			
            render interviewDetailsInstance as JSON
			return
        }
		
        flash.message = message(code: 'default.created.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), interviewDetailsInstance.id])
		
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
            render interviewDetailsInstance as JSON
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'interviewDetails.label', default: 'InterviewDetails'), id])
            redirect(action: "show", id: id)
        }
    }
}
