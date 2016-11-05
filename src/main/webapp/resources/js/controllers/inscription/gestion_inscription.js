'use strict';

App.controller('gestionController',[ '$scope' , '$http' ,  function($scope , $http) {
	 var self = this;
	 $scope.test = 'zakaria';
	 self.message = {}; 
	 $scope.users = [];
	 $scope.vrai = "Valide";
	 $scope.faux = "Invalide";
	 
	 $scope.bool = function(val){
	     if(val=== true)
	            return "lab"
	     else 
	         return "lab2";
	    };
	 $scope.changeCss = function(val){
	     if(val=== true)
	            return "btn-warning"
	     else 
	         return "btn-success ";
	    };
	 $scope.charger = function() {
		 $http.get('http://localhost:8080/etudiants')
		 .success (function(data){
               $scope.users = data;
               console.log('Users List', $scope.users);    
           });
	 };	              
	 $scope.validerCompte = function(id) {
		 $http.get('http://localhost:8080/validerCompte/'+id)
		   .success (function(data){
			   alert('Valideeeeeeeeeeeeer');		   
			   $scope.charger();
		         
		           });
	 };
	 self.supprimerCompte = function(id) {
		 $http.get('http://localhost:8080/supprimerCompte/'+id)
		   .success (function(data){
			   $scope.charger();
		               console.log('Utilisateur Supprimer');    
		           });
	 }; 
	 self.rejeterCompte =function(id){
		 $http.get('http://localhost:8080/rejeterCompte/'+id)
		   .success (function(data){
			   $scope.charger();
		           });
	 };
    $scope.valider= function(id) {
       
            console.log('Valdation de l inscription');    
            $scope.validerCompte(id);     
    };
    $scope.supprimer = function(id) {
       
        self.supprimerCompte(id);
        
    };
    
    $scope.rejeter= function(id) {
    
		self.rejeterCompte(id);     
	};
	
	$scope.charger();
}]);

