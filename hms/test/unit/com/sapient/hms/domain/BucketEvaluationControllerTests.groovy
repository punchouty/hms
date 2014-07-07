package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.BucketEvaluationResultController;

import grails.test.mixin.*

@TestFor(BucketEvaluationResultController)
@Mock(BucketEvaluation)
class BucketEvaluationControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/bucketEvaluationResult/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.bucketEvaluationResultInstanceList.size() == 0
        assert model.bucketEvaluationResultInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.bucketEvaluationResultInstance != null
    }

    void testSave() {
        controller.save()

        assert model.bucketEvaluationResultInstance != null
        assert view == '/bucketEvaluationResult/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/bucketEvaluationResult/show/1'
        assert controller.flash.message != null
        assert BucketEvaluation.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/bucketEvaluationResult/list'

        populateValidParams(params)
        def bucketEvaluationResult = new BucketEvaluation(params)

        assert bucketEvaluationResult.save() != null

        params.id = bucketEvaluationResult.id

        def model = controller.show()

        assert model.bucketEvaluationResultInstance == bucketEvaluationResult
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/bucketEvaluationResult/list'

        populateValidParams(params)
        def bucketEvaluationResult = new BucketEvaluation(params)

        assert bucketEvaluationResult.save() != null

        params.id = bucketEvaluationResult.id

        def model = controller.edit()

        assert model.bucketEvaluationResultInstance == bucketEvaluationResult
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/bucketEvaluationResult/list'

        response.reset()

        populateValidParams(params)
        def bucketEvaluationResult = new BucketEvaluation(params)

        assert bucketEvaluationResult.save() != null

        // test invalid parameters in update
        params.id = bucketEvaluationResult.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/bucketEvaluationResult/edit"
        assert model.bucketEvaluationResultInstance != null

        bucketEvaluationResult.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/bucketEvaluationResult/show/$bucketEvaluationResult.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        bucketEvaluationResult.clearErrors()

        populateValidParams(params)
        params.id = bucketEvaluationResult.id
        params.version = -1
        controller.update()

        assert view == "/bucketEvaluationResult/edit"
        assert model.bucketEvaluationResultInstance != null
        assert model.bucketEvaluationResultInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/bucketEvaluationResult/list'

        response.reset()

        populateValidParams(params)
        def bucketEvaluationResult = new BucketEvaluation(params)

        assert bucketEvaluationResult.save() != null
        assert BucketEvaluation.count() == 1

        params.id = bucketEvaluationResult.id

        controller.delete()

        assert BucketEvaluation.count() == 0
        assert BucketEvaluation.get(bucketEvaluationResult.id) == null
        assert response.redirectedUrl == '/bucketEvaluationResult/list'
    }
}
