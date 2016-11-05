'use strict';
 
App.controller('motPasseController', ['$scope','$http','$window', '$location' ,function($scope, $http,$window , $location) {
	 var self = this;
	// $scope.email = "zzdzde";
	 self.email='';
	 var getmotPassUrl ='http://localhost:8080/user/getmotPasse';
     self.submit = function(m) {
        
             console.log('sending mail TO =>', m);    
             //self.connectCompte(self.email); 
             $http.post(getmotPassUrl+"?email="+self.email)
             .then(
                     function(response){
                         console.log('gettinng Mail');
                    	 
                    	 if(Object.keys(response.data).length === 0){
                    		 console.log('Invalid Email', self.email);
                    	 }	 
                    	 else{		 
                    		console.log('angularJS Compte =>',response.data);
                      	 	//$window.location.href = "login2.html";
                    		alert('verifier votre boite mail');
                    		$location.path('/login');
                    		//$location.url('/');
                    		//alert('verifier votre boite mail');
                    		//$window.location.href = 'http://localhost:8080/empsi/';

                         }
                     }, 
                     function(errResponse){
                         console.error('Error gettinng Mail');
                 		 alert('Email invalid');
                     }
             );
     };
}]);