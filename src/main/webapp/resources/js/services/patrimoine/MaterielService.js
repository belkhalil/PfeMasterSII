/**
 * 
 */
'use strict';
App.factory('MaterielService', ['$http', '$q', function($http, $q){
	 
    return {
    	getOneMateriel: function(id){
    	    	return $http.get("/patrimoine/getOneMateriel/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching materiel');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllMateriels: function() {
                    return $http.get("/patrimoine/materiels")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching materiel');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createMateriel: function(materiel){
                    return $http.post("/patrimoine/saveMateriel/", materiel)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating materiel');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateMateriel: function(materiel, id){
                    return $http.put("/patrimoine/updateMateriel/"+id, materiel)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating materiel');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteMateriel: function(id){
                    return $http.delete("/patrimoine/deleteMateriel/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting materiel');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
  

    };
 }]);