package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.CandidateDetailsController;

import grails.test.mixin.*

@TestFor(CandidateDetailsController)
@Mock(CandidateDetail)
class CandidateDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/candidateDetails/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.candidateDetailsInstanceList.size() == 0
        assert model.candidateDetailsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.candidateDetailsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.candidateDetailsInstance != null
        assert view == '/candidateDetails/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/candidateDetails/show/1'
        assert controller.flash.message != null
        assert CandidateDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/candidateDetails/list'

        populateValidParams(params)
        def candidateDetails = new CandidateDetail(params)

        assert candidateDetails.save() != null

        params.id = candidateDetails.id

        def model = controller.show()

        assert model.candidateDetailsInstance == candidateDetails
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/candidateDetails/list'

        populateValidParams(params)
        def candidateDetails = new CandidateDetail(params)

        assert candidateDetails.save() != null

        params.id = candidateDetails.id

        def model = controller.edit()

        assert model.candidateDetailsInstance == candidateDetails
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/candidateDetails/list'

        response.reset()

        populateValidParams(params)
        def candidateDetails = new CandidateDetail(params)

        assert candidateDetails.save() != null

        // test invalid parameters in update
        params.id = candidateDetails.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/candidateDetails/edit"
        assert model.candidateDetailsInstance != null

        candidateDetails.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/candidateDetails/show/$candidateDetails.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        candidateDetails.clearErrors()

        populateValidParams(params)
        params.id = candidateDetails.id
        params.version = -1
        controller.update()

        assert view == "/candidateDetails/edit"
        assert model.candidateDetailsInstance != null
        assert model.candidateDetailsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/candidateDetails/list'

        response.reset()

        populateValidParams(params)
        def candidateDetails = new CandidateDetail(params)

        assert candidateDetails.save() != null
        assert CandidateDetail.count() == 1

        params.id = candidateDetails.id

        controller.delete()

        assert CandidateDetail.count() == 0
        assert CandidateDetail.get(candidateDetails.id) == null
        assert response.redirectedUrl == '/candidateDetails/list'
    }
}
