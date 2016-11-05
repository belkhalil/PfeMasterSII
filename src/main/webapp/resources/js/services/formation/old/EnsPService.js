/**
 * 
 */
'use strict';

App.factory('EnsPService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneEnsp: function(id){
    	    	return $http.get("http://localhost:8080/formation/getOneEnsp/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching ensp');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	   
            fetchEnsps: function() {
                    return $http.get("http://localhost:8080/formation/ensPermanents")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching ensp');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
             
            createEnsp: function(ensp){
                    return $http.post("http://localhost:8080/formation/saveEnsp", ensp)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating ensp');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateEnsp: function(ensP, id){
                    return $http.put("http://localhost:8080/formation/updateEnsP/"+id, ensP)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteEnsp: function(id){
                    return $http.delete("http://localhost:8080/formation/deleteEnsP/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting ensp');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
     
}]);
