package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.AssessmentRoundController;

import grails.test.mixin.*

@TestFor(AssessmentRoundController)
@Mock(AssessmentRound)
class AssessmentRoundControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/assessmentRound/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.assessmentRoundInstanceList.size() == 0
        assert model.assessmentRoundInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.assessmentRoundInstance != null
    }

    void testSave() {
        controller.save()

        assert model.assessmentRoundInstance != null
        assert view == '/assessmentRound/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/assessmentRound/show/1'
        assert controller.flash.message != null
        assert AssessmentRound.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/assessmentRound/list'

        populateValidParams(params)
        def assessmentRound = new AssessmentRound(params)

        assert assessmentRound.save() != null

        params.id = assessmentRound.id

        def model = controller.show()

        assert model.assessmentRoundInstance == assessmentRound
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/assessmentRound/list'

        populateValidParams(params)
        def assessmentRound = new AssessmentRound(params)

        assert assessmentRound.save() != null

        params.id = assessmentRound.id

        def model = controller.edit()

        assert model.assessmentRoundInstance == assessmentRound
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/assessmentRound/list'

        response.reset()

        populateValidParams(params)
        def assessmentRound = new AssessmentRound(params)

        assert assessmentRound.save() != null

        // test invalid parameters in update
        params.id = assessmentRound.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/assessmentRound/edit"
        assert model.assessmentRoundInstance != null

        assessmentRound.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/assessmentRound/show/$assessmentRound.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        assessmentRound.clearErrors()

        populateValidParams(params)
        params.id = assessmentRound.id
        params.version = -1
        controller.update()

        assert view == "/assessmentRound/edit"
        assert model.assessmentRoundInstance != null
        assert model.assessmentRoundInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/assessmentRound/list'

        response.reset()

        populateValidParams(params)
        def assessmentRound = new AssessmentRound(params)

        assert assessmentRound.save() != null
        assert AssessmentRound.count() == 1

        params.id = assessmentRound.id

        controller.delete()

        assert AssessmentRound.count() == 0
        assert AssessmentRound.get(assessmentRound.id) == null
        assert response.redirectedUrl == '/assessmentRound/list'
    }
}
