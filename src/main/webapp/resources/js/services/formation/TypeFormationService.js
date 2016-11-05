/**
 * 
 */
'use strict';
App.factory('typeFormationService', ['$http', '$q', function($http, $q){
    return {
    	getOneTypeFormation: function(id){
    	    	return $http.get("/formation/getOneTypeFormation/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching les types');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
            fetchAllTypeFormations: function() {
                    return $http.get("/formation/typeFormations")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching types');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createTypeFormation: function(typeFormation){
                    return $http.post("/formation/savetypeFormation", typeFormation)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating type f');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateTypeFormation: function(typeFormation, id){
                    return $http.put("/formation/updateTypeFormation/"+id, typeFormation)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating type f');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteTypeFormation: function(id){
                    return $http.delete("/formation/deleteTypeFormation/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting type f ');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
    };
 }]);