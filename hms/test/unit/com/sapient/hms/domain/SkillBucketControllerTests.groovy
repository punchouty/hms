package com.sapient.hms.domain



import org.junit.*

import com.sapient.hms.controllers.SkillBucketController;

import grails.test.mixin.*

@TestFor(SkillBucketController)
@Mock(SkillBucket)
class SkillBucketControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/skillBucket/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.skillBucketInstanceList.size() == 0
        assert model.skillBucketInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.skillBucketInstance != null
    }

    void testSave() {
        controller.save()

        assert model.skillBucketInstance != null
        assert view == '/skillBucket/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/skillBucket/show/1'
        assert controller.flash.message != null
        assert SkillBucket.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/skillBucket/list'

        populateValidParams(params)
        def skillBucket = new SkillBucket(params)

        assert skillBucket.save() != null

        params.id = skillBucket.id

        def model = controller.show()

        assert model.skillBucketInstance == skillBucket
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/skillBucket/list'

        populateValidParams(params)
        def skillBucket = new SkillBucket(params)

        assert skillBucket.save() != null

        params.id = skillBucket.id

        def model = controller.edit()

        assert model.skillBucketInstance == skillBucket
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/skillBucket/list'

        response.reset()

        populateValidParams(params)
        def skillBucket = new SkillBucket(params)

        assert skillBucket.save() != null

        // test invalid parameters in update
        params.id = skillBucket.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/skillBucket/edit"
        assert model.skillBucketInstance != null

        skillBucket.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/skillBucket/show/$skillBucket.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        skillBucket.clearErrors()

        populateValidParams(params)
        params.id = skillBucket.id
        params.version = -1
        controller.update()

        assert view == "/skillBucket/edit"
        assert model.skillBucketInstance != null
        assert model.skillBucketInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/skillBucket/list'

        response.reset()

        populateValidParams(params)
        def skillBucket = new SkillBucket(params)

        assert skillBucket.save() != null
        assert SkillBucket.count() == 1

        params.id = skillBucket.id

        controller.delete()

        assert SkillBucket.count() == 0
        assert SkillBucket.get(skillBucket.id) == null
        assert response.redirectedUrl == '/skillBucket/list'
    }
}
