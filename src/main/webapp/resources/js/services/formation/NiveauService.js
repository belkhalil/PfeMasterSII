/**
 * 
 */
'use strict';
App.factory('NiveauService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneNiveau: function(id){
    	    	return $http.get("/formation/getOneNiveau/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching niveau');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllNiveaux: function() {
                    return $http.get("/formation/niveaux")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching niveaux');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createNiveau: function(niveau){
                    return $http.post("/formation/saveNiveau", niveau)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating niveau');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateNiveau: function(niveau, id){
                    return $http.put("/formation/updateNiveau/"+id, niveau)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating niveau');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteNiveau: function(id){
                    return $http.delete("/formation/deleteNiveau/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting niveau');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
        addFormationToNiveau : function(idF,idN){
    	   
      	 return $http.post("/formation/addFormationToNiveau/"+"?idf="+idF+"&idn="+idN)
      	 		.then(function(response){		
   				return response.data ;
   			},
   			function(errResponse){
   				console.error('Error while adding formation to niveau (service)');
                return $q.reject(errResponse);
   			});
        },   
//        addSemestreToNiveau : function(idS,idN){
//         	   
//             	 return $http.post("/formation/addSemestreToNiveau/"+"?ids="+idS+"&idn="+idN)
//             	 		.then(function(response){		
//          				return response.data ;
//          			},
//          			function(errResponse){
//          				console.error('Error while adding semestre to niveau');
//                       return $q.reject(errResponse);
//          			});
//        },
        removeFormationFromNiveau : function() {
        	return $http.delete("/formation/removeFormationFromNiveau/"+"?idf="+idF+"&idn="+idN)
 	 		.then(function(response){		
				return response.data ;
			},
			function(errResponse){
				console.error('Error while removing formation from niveau');
           return $q.reject(errResponse);
			});
		}
    };
 }]);