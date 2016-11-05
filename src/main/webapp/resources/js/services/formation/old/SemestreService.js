/**
 * 
 */
'use strict';
App.factory('SemestreService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneSemestre: function(id){
    	    	return $http.get("/formation/getOneSemestre/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching Semestres');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllSemestre: function() {
                    return $http.get("/formation/Semestres")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching Semestre');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createSemestre: function(Semestre){
                    return $http.post("/formation/saveSemestre", Semestre)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating Semestre');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateSemestre: function(Semestre, id){
                    return $http.put("/formation/updateSemestre/"+id, Semestre)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating Semestre');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteSemestre: function(id){
                    return $http.delete("/formation/deleteSemestre/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting Semestre');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
        
          
    };
 }]);