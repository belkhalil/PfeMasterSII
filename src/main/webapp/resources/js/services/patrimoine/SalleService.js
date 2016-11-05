/**
 * 
 */
'use strict';
App.factory('SalleService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneSalle: function(id){
    	    	return $http.get("/patrimoine/getOneSalle/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching salle');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllSalles: function() {
                    return $http.get("/patrimoine/salles")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching salle');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createSalle: function(salle){
                    return $http.post("/patrimoine/saveSalle", salle)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating salle');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateSalle: function(salle, id){
                    return $http.put("/patrimoine/updateSalle/"+id, salle)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating salle');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteSalle: function(id){
                    return $http.delete("/patrimoine/deleteSalle/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting salle');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
//         addMatiereToSemestre : function(idM,idS){
//      	 return $http.post("/patrimoine/addMatiereToSemestre/"+"?idm="+idM+"&ids="+idS)
//      	 		.then(function(response){		
//   				return response.data ;
//   			},
//   			function(errResponse){
//   				console.error('Error while adding Matiere to semestre (service)');
//                return $q.reject(errResponse);
//   			});
//         }   

    };
 }]);