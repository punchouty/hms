package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.SkillEvaluationresultController;

import grails.test.mixin.*

@TestFor(SkillEvaluationresultController)
@Mock(SkillEvaluation)
class SkillEvaluationControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/skillEvaluationresult/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.skillEvaluationresultInstanceList.size() == 0
        assert model.skillEvaluationresultInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.skillEvaluationresultInstance != null
    }

    void testSave() {
        controller.save()

        assert model.skillEvaluationresultInstance != null
        assert view == '/skillEvaluationresult/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/skillEvaluationresult/show/1'
        assert controller.flash.message != null
        assert SkillEvaluation.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/skillEvaluationresult/list'

        populateValidParams(params)
        def skillEvaluationresult = new SkillEvaluation(params)

        assert skillEvaluationresult.save() != null

        params.id = skillEvaluationresult.id

        def model = controller.show()

        assert model.skillEvaluationresultInstance == skillEvaluationresult
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/skillEvaluationresult/list'

        populateValidParams(params)
        def skillEvaluationresult = new SkillEvaluation(params)

        assert skillEvaluationresult.save() != null

        params.id = skillEvaluationresult.id

        def model = controller.edit()

        assert model.skillEvaluationresultInstance == skillEvaluationresult
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/skillEvaluationresult/list'

        response.reset()

        populateValidParams(params)
        def skillEvaluationresult = new SkillEvaluation(params)

        assert skillEvaluationresult.save() != null

        // test invalid parameters in update
        params.id = skillEvaluationresult.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/skillEvaluationresult/edit"
        assert model.skillEvaluationresultInstance != null

        skillEvaluationresult.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/skillEvaluationresult/show/$skillEvaluationresult.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        skillEvaluationresult.clearErrors()

        populateValidParams(params)
        params.id = skillEvaluationresult.id
        params.version = -1
        controller.update()

        assert view == "/skillEvaluationresult/edit"
        assert model.skillEvaluationresultInstance != null
        assert model.skillEvaluationresultInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/skillEvaluationresult/list'

        response.reset()

        populateValidParams(params)
        def skillEvaluationresult = new SkillEvaluation(params)

        assert skillEvaluationresult.save() != null
        assert SkillEvaluation.count() == 1

        params.id = skillEvaluationresult.id

        controller.delete()

        assert SkillEvaluation.count() == 0
        assert SkillEvaluation.get(skillEvaluationresult.id) == null
        assert response.redirectedUrl == '/skillEvaluationresult/list'
    }
}
