'use strict';

/* Services */

hms.factory('hiringService', function($resource, $log){
	
	 
	 var factory = {};
	 
	factory.getInterviews = function(){
		return $resource('book/listJSON').query();
		
	}
	
	factory.fetchData= function(){
		return $resource('book/listJSON').query();
		}
	
	
	factory.saveData = function(data){
		return $resource('book/save', {}, {'save': {method:'POST'}}).save(data);
	}
	
	factory.editData = function(data){
		return $resource('book/update', {}, {'update': {method:'PUT'}}).update(data);
	}
	
	factory.deleteData= function(id){
		return $resource('book/delete', {}, {'delete': {method:'DELETE'}}).delete({'id':id});
		}
	
	factory.showData= function(id){
		$log.info("CALLLLED:"+id)
		return $resource('book/show/:id', {id:'@id'}).get({id:id});
		}
	return factory;
});