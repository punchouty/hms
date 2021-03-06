package com.sapient.hms.controllers
import grails.converters.JSON;
import hms.CandidateDetailVO
import java.text.SimpleDateFormat
import org.springframework.dao.DataIntegrityViolationException
import com.sapient.hms.domain.CandidateDetail;
class CandidateDetailsController {
	static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]
	def index() {
		redirect(action: "list", params: params)
	}
	def list() {
		def candidates = CandidateDetail.list()
		render candidates.collect{ [ id: it.id, name: it.name,emailId:it.emailId,panNo:it.panNo,contactNumber:it.contactNumber ,passportNumber:it.passportNumber] } as JSON
	}
	//
	// def create() {
	// [candidateDetailsInstance: new CandidateDetail(params)]
	// }
	def save() {
		def result = request.JSON
		def df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		result.dateCreated = df.parse(result.dateCreated)
		def candidateDetailsInstance = new CandidateDetail(result)
		boolean flag=candidateDetailsInstance.save(flush: true)
		if (flag==null||flag==false) {
			def errorMessage = [error : "error occured,please try again"]
			render errorMessage as JSON
			return
		}
		render candidateDetailsInstance as JSON
	}
	def search(){
		def result=request.JSON
		def CandidateDetailInstance=new CandidateDetail();
				
		if(result.name){
			 CandidateDetailInstance=CandidateDetail.findAll{
				like('name','%'+result.name+'%')
			}
		}
		
		 else if(result.panNo){
			 CandidateDetailInstance=CandidateDetail.findAllByPanNo(result.panNo)			
		}
		 
		 else{
			 def errorMessage = [error : "error occured,please try again"]
			 render errorMessage as JSON
			 return
		 }
		def CandidateList = new ArrayList<CandidateDetailVO>()
		   CandidateDetailInstance.each{
			def candidateVO = new CandidateDetailVO();
			candidateVO.id = it.id;
			candidateVO.name = it.name;
			candidateVO.contactNumber = it.contactNumber
			candidateVO.panNo = it.panNo
			candidateVO.passportNumber = it.passportNumber
			candidateVO.emailId = it.emailId
			CandidateList.add(candidateVO)
		}
		render CandidateList as JSON
	}
	
	
	def update(){
		def result=request.JSON
		def candidateInstance=CandidateDetail.get(result.id)
		if(result.name){
			candidateInstance.name=result.name
			candidateInstance.emailId=result.emailId
			candidateInstance.panNo=result.panNo
			candidateInstance.passportNumber=result.passportNumber
			candidateInstance.contactNumber=result.contactNumber
		}
		boolean flag=candidateInstance.save(flush: true)
		if (flag==null||flag==false) {
			def errorMessage = [error : "error occured,please try again"]
			render errorMessage as JSON
			return
		}
		render candidateInstance as JSON
	}
	// def show(Long id) {
	// def candidateDetailsInstance = CandidateDetail.get(id)
	// if (!candidateDetailsInstance) {
	// flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	// redirect(action: "list")
	// return
	// }
	//
	// [candidateDetailsInstance: candidateDetailsInstance]
	// }
	//
	// def edit(Long id) {
	// def candidateDetailsInstance = CandidateDetail.get(id)
	// if (!candidateDetailsInstance) {
	// flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	// redirect(action: "list")
	// return
	// }
	//
	// [candidateDetailsInstance: candidateDetailsInstance]
	// }
	//
	// def update(Long id, Long version) {
	// def candidateDetailsInstance = CandidateDetail.get(id)
	// if (!candidateDetailsInstance) {
	// flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	// redirect(action: "list")
	// return
	// }
	//
	// if (version != null) {
	// if (candidateDetailsInstance.version > version) {
	// candidateDetailsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
	// [message(code: 'candidateDetails.label', default: 'CandidateDetails')] as Object[],
	// "Another user has updated this CandidateDetails while you were editing")
	// render(view: "edit", model: [candidateDetailsInstance: candidateDetailsInstance])
	// return
	// }
	// }
	//
	// candidateDetailsInstance.properties = params
	//
	// if (!candidateDetailsInstance.save(flush: true)) {
	// render(view: "edit", model: [candidateDetailsInstance: candidateDetailsInstance])
	// return
	// }
	//
	// flash.message = message(code: 'default.updated.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), candidateDetailsInstance.id])
	// redirect(action: "show", id: candidateDetailsInstance.id)
	// }
	//
	// def delete(Long id) {
	// def candidateDetailsInstance = CandidateDetail.get(id)
	// if (!candidateDetailsInstance) {
	// flash.message = message(code: 'default.not.found.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	// redirect(action: "list")
	// return
	// }
	//
	// try {
	// candidateDetailsInstance.delete(flush: true)
	// flash.message = message(code: 'default.deleted.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	// redirect(action: "list")
	// }
	// catch (DataIntegrityViolationException e) {
	// flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'candidateDetails.label', default: 'CandidateDetails'), id])
	// redirect(action: "show", id: id)
	// }
	// }
}