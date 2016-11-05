/**
 * 
 */
'use strict';
App.factory('SeanceService', ['$http', '$q', function($http, $q){
	 
    return {
    	getOneSeance: function(id){
    	    	return $http.get("/formation/getOneSeance/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching Seance');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllSeances: function() {
                    return $http.get("/formation/Seances")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching Seance');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createSeance: function(seance){
                    return $http.post("/formation/saveSeance", seance)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating seance');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateSeance: function(seance, id){
                    return $http.put("/formation/updateSeance/"+id, seance)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating seance');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteSeance: function(id){
                    return $http.delete("/formation/deleteSeance/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting seance');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
            addSeanceToMatiere : function(idS,idM){
      	 return $http.post("/formation/addSeanceToMatiere/"+"?ids="+idS+"&idm="+idM)
      	 		.then(function(response){		
   				return response.data ;
   			},
   			function(errResponse){
   				console.error('Error while adding seance to matiere (service)');
                return $q.reject(errResponse);
   			});
         },   

    };
 }]);