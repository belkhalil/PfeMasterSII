'use strict';
 
App.controller('CompteController', function($scope ,$window, $http) {
	 var self = this;
	 self.compte={login:'',password:''};
	 
	 self.connectCompte = function(compte){
        
		 $http.post('http://localhost:8080/empsi/login/', compte)
         .then(
                 function(response){
                	 //var path = "home.html";
            		 //window.location.href = path;
                	 if(response.data == null)
                		 return null;
                	 else
                		console.error('angularJS',response.data);
                	 	$window.location.href = "welcoome.html";
                     	return response.data;
                 }, 
                 function(errResponse){
                     console.error('Error while creating user');
                     return $q.reject(errResponse);
                 }
         );
		 
		 
                 
     };
     self.submit = function() {
        
             console.log('Connecting Compte', self.compte);    
             self.connectCompte(self.compte);     
     };
});