package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.HiringProcessController;

import grails.test.mixin.*

@TestFor(HiringProcessController)
@Mock(HiringProcess)
class HiringProcessControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/hiringProcess/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.hiringProcessInstanceList.size() == 0
        assert model.hiringProcessInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.hiringProcessInstance != null
    }

    void testSave() {
        controller.save()

        assert model.hiringProcessInstance != null
        assert view == '/hiringProcess/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/hiringProcess/show/1'
        assert controller.flash.message != null
        assert HiringProcess.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/hiringProcess/list'

        populateValidParams(params)
        def hiringProcess = new HiringProcess(params)

        assert hiringProcess.save() != null

        params.id = hiringProcess.id

        def model = controller.show()

        assert model.hiringProcessInstance == hiringProcess
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/hiringProcess/list'

        populateValidParams(params)
        def hiringProcess = new HiringProcess(params)

        assert hiringProcess.save() != null

        params.id = hiringProcess.id

        def model = controller.edit()

        assert model.hiringProcessInstance == hiringProcess
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/hiringProcess/list'

        response.reset()

        populateValidParams(params)
        def hiringProcess = new HiringProcess(params)

        assert hiringProcess.save() != null

        // test invalid parameters in update
        params.id = hiringProcess.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/hiringProcess/edit"
        assert model.hiringProcessInstance != null

        hiringProcess.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/hiringProcess/show/$hiringProcess.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        hiringProcess.clearErrors()

        populateValidParams(params)
        params.id = hiringProcess.id
        params.version = -1
        controller.update()

        assert view == "/hiringProcess/edit"
        assert model.hiringProcessInstance != null
        assert model.hiringProcessInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/hiringProcess/list'

        response.reset()

        populateValidParams(params)
        def hiringProcess = new HiringProcess(params)

        assert hiringProcess.save() != null
        assert HiringProcess.count() == 1

        params.id = hiringProcess.id

        controller.delete()

        assert HiringProcess.count() == 0
        assert HiringProcess.get(hiringProcess.id) == null
        assert response.redirectedUrl == '/hiringProcess/list'
    }
}
