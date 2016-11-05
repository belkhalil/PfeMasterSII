
'use strict';
App.factory('FormationDService', ['$http', '$q', function($http, $q){
	 
    return {
    	    addTypeToFormation : function(idT,idF){
    	    	return $http.post("http://localhost:8080/formation/addTypeToFormation/"+"?idt="+idT+"&idf="+idF)
      	 		.then(function(response){		
   				return response.data ;
   				},
   			function(errResponse){
   				console.error('Error while adding type to formation');
                return $q.reject(errResponse);
   			});
    	    },
    	    getOneFormation: function(id){
    	    	return $http.get("http://localhost:8080/formation/getOneFormationD/"+id)
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
                    return $http.get("/formation/formationsD")
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
                    return $http.post("/formation/saveformationD", formation)
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
                    return $http.put("/formation/updateFormationD/"+id, formation)
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
                    return $http.delete("/formation/deleteformationD/"+id)
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