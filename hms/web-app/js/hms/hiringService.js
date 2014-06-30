'use strict';

/* Services */

hms.factory('hiringService', function($resource, $log){
	 
	var factory = {};
	 
	factory.getInterviews = function(){
		return $resource('interviewDetails/list').query();
		
	}
		
	factory.saveData = function(data){
		return $resource('schedule/save', {}, {'save': {method:'POST'}}).save(data);
	}
	
	factory.editData = function(data){
		return $resource('schedule/update', {}, {'update': {method:'PUT'}}).update(data);
	}
	
	factory.deleteData= function(id){
		return $resource('schedule/delete', {}, {'delete': {method:'DELETE'}}).delete({'id':id});
		}
	
	factory.showData= function(id){
			return $resource('schedule/show/:id', {id:'@id'}).get({id:id});
		}
	return factory;
});