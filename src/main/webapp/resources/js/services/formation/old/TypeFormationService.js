/**
 * 
 */
'use strict';
app.factory('typeFormationService', ['$http', '$q', function($http, $q){
    return {
    	getOneTypeFormation: function(id){
    	    	return $http.get("http://localhost:8080/formation/getOneTypeFormation/"+id)
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
                    return $http.get("http://localhost:8080/formation/typeFormations")
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
                    return $http.post("http://localhost:8080/formation/savetypeFormation", typeFormation)
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
                    return $http.put("http://localhost:8080/formation/updateTypeFormation/"+id, typeFormation)
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
                    return $http.delete("http://localhost:8080/formation/deleteTypeFormation/"+id)
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