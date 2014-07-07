package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.RoundEvaluationController;

import grails.test.mixin.*

@TestFor(RoundEvaluationController)
@Mock(RoundEvaluation)
class RoundEvaluationControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/roundEvaluationResult/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.roundEvaluationResultInstanceList.size() == 0
        assert model.roundEvaluationResultInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.roundEvaluationResultInstance != null
    }

    void testSave() {
        controller.save()

        assert model.roundEvaluationResultInstance != null
        assert view == '/roundEvaluationResult/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/roundEvaluationResult/show/1'
        assert controller.flash.message != null
        assert RoundEvaluation.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/roundEvaluationResult/list'

        populateValidParams(params)
        def roundEvaluationResult = new RoundEvaluation(params)

        assert roundEvaluationResult.save() != null

        params.id = roundEvaluationResult.id

        def model = controller.show()

        assert model.roundEvaluationResultInstance == roundEvaluationResult
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/roundEvaluationResult/list'

        populateValidParams(params)
        def roundEvaluationResult = new RoundEvaluation(params)

        assert roundEvaluationResult.save() != null

        params.id = roundEvaluationResult.id

        def model = controller.edit()

        assert model.roundEvaluationResultInstance == roundEvaluationResult
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/roundEvaluationResult/list'

        response.reset()

        populateValidParams(params)
        def roundEvaluationResult = new RoundEvaluation(params)

        assert roundEvaluationResult.save() != null

        // test invalid parameters in update
        params.id = roundEvaluationResult.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/roundEvaluationResult/edit"
        assert model.roundEvaluationResultInstance != null

        roundEvaluationResult.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/roundEvaluationResult/show/$roundEvaluationResult.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        roundEvaluationResult.clearErrors()

        populateValidParams(params)
        params.id = roundEvaluationResult.id
        params.version = -1
        controller.update()

        assert view == "/roundEvaluationResult/edit"
        assert model.roundEvaluationResultInstance != null
        assert model.roundEvaluationResultInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/roundEvaluationResult/list'

        response.reset()

        populateValidParams(params)
        def roundEvaluationResult = new RoundEvaluation(params)

        assert roundEvaluationResult.save() != null
        assert RoundEvaluation.count() == 1

        params.id = roundEvaluationResult.id

        controller.delete()

        assert RoundEvaluation.count() == 0
        assert RoundEvaluation.get(roundEvaluationResult.id) == null
        assert response.redirectedUrl == '/roundEvaluationResult/list'
    }
}
