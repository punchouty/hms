package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.InterviewDetailsController;

import grails.test.mixin.*

@TestFor(InterviewDetailsController)
@Mock(InterviewDetails)
class InterviewDetailsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/interviewDetails/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.interviewDetailsInstanceList.size() == 0
        assert model.interviewDetailsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.interviewDetailsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.interviewDetailsInstance != null
        assert view == '/interviewDetails/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/interviewDetails/show/1'
        assert controller.flash.message != null
        assert InterviewDetails.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/interviewDetails/list'

        populateValidParams(params)
        def interviewDetails = new InterviewDetails(params)

        assert interviewDetails.save() != null

        params.id = interviewDetails.id

        def model = controller.show()

        assert model.interviewDetailsInstance == interviewDetails
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/interviewDetails/list'

        populateValidParams(params)
        def interviewDetails = new InterviewDetails(params)

        assert interviewDetails.save() != null

        params.id = interviewDetails.id

        def model = controller.edit()

        assert model.interviewDetailsInstance == interviewDetails
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/interviewDetails/list'

        response.reset()

        populateValidParams(params)
        def interviewDetails = new InterviewDetails(params)

        assert interviewDetails.save() != null

        // test invalid parameters in update
        params.id = interviewDetails.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/interviewDetails/edit"
        assert model.interviewDetailsInstance != null

        interviewDetails.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/interviewDetails/show/$interviewDetails.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        interviewDetails.clearErrors()

        populateValidParams(params)
        params.id = interviewDetails.id
        params.version = -1
        controller.update()

        assert view == "/interviewDetails/edit"
        assert model.interviewDetailsInstance != null
        assert model.interviewDetailsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/interviewDetails/list'

        response.reset()

        populateValidParams(params)
        def interviewDetails = new InterviewDetails(params)

        assert interviewDetails.save() != null
        assert InterviewDetails.count() == 1

        params.id = interviewDetails.id

        controller.delete()

        assert InterviewDetails.count() == 0
        assert InterviewDetails.get(interviewDetails.id) == null
        assert response.redirectedUrl == '/interviewDetails/list'
    }
}
