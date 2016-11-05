'use strict';
 
App.factory('CompteService', ['$http', '$q', function($http, $q){
 
    return {
    	
    	connectCompte: function(compte){
            return $http.post('http://localhost:8080/empsi/login/', compte)
                    .then(
                            function(response){
                            	
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while creating user');
                                return $q.reject(errResponse);
                            }
                    );
    	}
    
    };
    
}]);