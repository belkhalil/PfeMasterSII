/**
 * 
 */

'use strict';


App.factory('FormationService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneFormation: function(id){
    	    	return $http.get("/formation/getOneFormation/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching formation');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
            fetchAllFormations: function() {
                    return $http.get("/formation/formations")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching formations');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
             
            createFormation: function(formation){
                    return $http.post("/formation/saveformation", formation)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating formation');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateFormation: function(formation, id){
                    return $http.put("/formation/updateFormation/"+id, formation)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating formation');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteFormation: function(id){
                    return $http.delete("/formation/deleteformation/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting formation');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
    
   
    
 
}]);
