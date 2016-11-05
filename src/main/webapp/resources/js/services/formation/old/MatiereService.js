/**
 * 
 */
'use strict';
App.factory('MatiereService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneMatiere: function(id){
    	    	return $http.get("/formation/getOneMatiere/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching Matiere');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllMatieres: function() {
                    return $http.get("/formation/matieres")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching Matiere');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createMatiere: function(matiere){
                    return $http.post("/saveMatiere", matiere)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating matiere');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateMatiere: function(matiere, id){
                    return $http.put("/updateMatiere/"+id, matiere)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating matiere');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteMatiere: function(id){
                    return $http.delete("/deleteMatiere/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting Matiere');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
//         addMatiereToSemestre : function(idM,idS){
//      	 return $http.post("/addMatiereToSemestre/"+"?idm="+idM+"&ids="+idS)
//      	 		.then(function(response){		
//   				return response.data ;
//   			},
//   			function(errResponse){
//   				console.error('Error while adding Matiere to semestre (service)');
//                return $q.reject(errResponse);
//   			});
//         },   
//        addSemestreTomodule : function(idS,idN){
//         	   
//             	 return $http.post("/addSemestreTomodule/"+"?ids="+idS+"&idn="+idN)
//             	 		.then(function(response){		
//          				return response.data ;
//          			},
//          			function(errResponse){
//          				console.error('Error while adding semestre to module');
//                       return $q.reject(errResponse);
//          			});
//        },
//        removeFormationFrommodule : function() {
//        	return $http.delete("/removeFormationFrommodule/"+"?idf="+idF+"&idn="+idN)
// 	 		.then(function(response){		
//				return response.data ;
//			},
//			function(errResponse){
//				console.error('Error while removing formation from module');
//           return $q.reject(errResponse);
//			});
//		}
    };
 }]);