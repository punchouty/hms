package com.sapient.hms.controllers

import grails.converters.JSON;

import org.springframework.dao.DataIntegrityViolationException

import com.sapient.hms.domain.CandidateDetail;

class CandidateDetailsController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		def candidates = CandidateDetail.list()
		render candidates.collect{ [ id: it.id, name: it.name, location: it.location,emailId:it.emailId,panNo:it.panNo,contactNumber:it.contactNumber ,passportNumber:it.passportNumber] } as JSON
	}
	//
	//    def create() {
	//        [candidateDetailsInstance: new CandidateDetail(params)]
	//    }

	def save() {
		def result = request.JSON
		def candidateDetailsInstance = new CandidateDetail(result)
		if (!candidateDetailsInstance.save(flush: true)) {
			render candidateDetailsInstance as JSON
			return
		}

		render candidateDetailsInstance as JSON

	}

	//    def show(Long id) {
	//        def candidateDetailsInstance = CandidateDetail.get(id)
	//        if (!candidateDetailsInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        [candidateDetailsInstance: candidateDetailsInstance]
	//    }
	//
	//    def edit(Long id) {
	//        def candidateDetailsInstance = CandidateDetail.get(id)
	//        if (!candidateDetailsInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        [candidateDetailsInstance: candidateDetailsInstance]
	//    }
	//
	//    def update(Long id, Long version) {
	//        def candidateDetailsInstance = CandidateDetail.get(id)
	//        if (!candidateDetailsInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        if (version != null) {
	//            if (candidateDetailsInstance.version > version) {
	//                candidateDetailsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
	//                          [message(code: 'candidateDetails.label', default: 'CandidateDetails')] as Object[],
	//                          "Another user has updated this CandidateDetails while you were editing")
	//                render(view: "edit", model: [candidateDetailsInstance: candidateDetailsInstance])
	//                return
	//            }
	//        }
	//
	//        candidateDetailsInstance.properties = params
	//
	//        if (!candidateDetailsInstance.save(flush: true)) {
	//            render(view: "edit", model: [candidateDetailsInstance: candidateDetailsInstance])
	//            return
	//        }
	//
	//        flash.message = message(code: 'default.updated.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), candidateDetailsInstance.id])
	//        redirect(action: "show", id: candidateDetailsInstance.id)
	//    }
	//
	//    def delete(Long id) {
	//        def candidateDetailsInstance = CandidateDetail.get(id)
	//        if (!candidateDetailsInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        try {
	//            candidateDetailsInstance.delete(flush: true)
	//            flash.message = message(code: 'default.deleted.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	//            redirect(action: "list")
	//        }
	//        catch (DataIntegrityViolationException e) {
	//            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	//            redirect(action: "show", id: id)
	//        }
	//    }
}
