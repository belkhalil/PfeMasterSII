/**
 * 
 */
'use strict';
App.factory('ModuleService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneModule: function(id){
    	    	return $http.get("/formation/getOneModule/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching module');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllModules: function() {
                    return $http.get("/formation/modules")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createModule: function(module){
                    return $http.post("/formation/saveModule", module)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateModule: function(module, id){
                    return $http.put("/formation/updateModule/"+id, module)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteModule: function(id){
                    return $http.delete("/formation/deleteModule/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
         addModuleToSemestre : function(idM,idS){
      	 return $http.post("/formation/addModuleToSemestre/"+"?idm="+idM+"&ids="+idS)
      	 		.then(function(response){		
   				return response.data ;
   			},
   			function(errResponse){
   				console.error('Error while adding module to semestre (service)');
                return $q.reject(errResponse);
   			});
         },   
         addMatiereToModule : function(idMa,idMo){
          	 return $http.post("/formation/addMatiereToModule/"+"?idma="+idMa+"&idmo="+idMo)
          	 		.then(function(response){		
       				return response.data ;
       			},
       			function(errResponse){
       				console.error('Error while adding matiere to module (service)');
                    return $q.reject(errResponse);
       			});
             },   
    };
 }]);