/**
 * 
 */
'use strict';

App.factory('EnsPService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneEnsp: function(id){
    	    	return $http.get("/formation/getOneEnsp/"+id)
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
                    return $http.get("/formation/ensPermanents")
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
                    return $http.post("/formation/saveEnsp", ensp)
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
                    return $http.put("/formation/updateEnsP/"+id, ensP)
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
                    return $http.delete("/formation/deleteEnsP/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting ensp');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            affecterMatiereToEnsP : function(idM,idE){
    	    	return $http.post("/formation/affecterMatiereToEnsP/"+"?idm="+idM+"&ide="+idE)
      	 		.then(function(response){		
   				return response.data ;
   				},
   			function(errResponse){
   				console.error('Error while affecting subject schoole to teacher');
                return $q.reject(errResponse);
   			});
    	    }
         
    };
     
}]);
