'use strict';
 
App.controller('CompteController', ['$scope', 'CompteService', function($scope, CompteService) {
	 var self = this;
	 self.compte={login:'',password:''};
	 self.connectCompte = function(compte){
        
                 
     };
     self.submit = function() {
        
             console.log('Connecting Compte', self.compte);    
             self.connectCompte(self.compte);     
     };
}]);