

'use strict';
App.controller('affectationMatieresEnsPController', ['$scope', 'EnsPService','MatiereService', function($scope, EnsPService,MatiereService) {
    var self = this;
    
    self.ensps=[];
    self.matieres=[];
    self.idSelectedMatiere=null;
    self.idSelectedensp=null;
    self.getOneEnsp = function(id){
    	EnsPService.getOneEnsp(id)
    	 .then(
                function(d) {
                     self.enspshow = d;
                         },
                 function(errResponse){
                     console.error('Error while fetching Currencies');
                 }
        );
    };
    
    self.fetchEnsps = function(){
    	EnsPService.fetchEnsps()
            .then(
                         function(d) {
                              self.ensps = d;  
                   
                         },
                          function(errResponse){
                              console.error('Error while fetching Currencies');
                          }
                 );
    };
    
    self.fetchAllMatieres = function() {
		MatiereService.fetchAllMatieres().then(function(d) {
			self.matieres = d;
		}, function(errResponse) {
			console.error('Error while fetching Currencies');
		});
	};
   
	 self.affecterMatiereToEnsP = function(idM, idE) {
			EnsPService.affecterMatiereToEnsP(idM, idE).then(function(d) {
				self.fetchEnsps();
				self.fetchAllMatieres();
				self.reset();
			}, function(errResponse) {
				console.error('Error while adding matiere to module.');
			});
		};
    
    self.fetchEnsps();
    self.fetchAllMatieres();
    
    self.update = function(){
    	console.log('updating d\'un ensp'+self.ensp.id);
    	self.updateEnsp(self.ensp, self.ensp.id);
    	self.reset();
    };
    
    self.add=function(){
    	
            console.log('affectation de la matiere', self.idSelectedMatiere+'au prof '+self.idSelectedensp);    
            self.affecterMatiereToEnsP(self.idSelectedMatiere,self.idSelectedensp);
        
        self.reset();
    };
     
    self.edit = function(id){
        for(var i = 0; i < self.ensps.length; i++){
            if(self.ensps[i].id == id) {
               self.ensp = angular.copy(self.ensps[i]);
               break;
            }
        }
    };
    
    self.remove = function(id){
        console.log('id to be deleted', id);
        EnsPService.deleteEnsp(id);
    };

//     self.show=function(id){
//    	 self.getOneEnsp(id);
//    	 $scope.showMe = !$scope.showMe;
//     };
     
    self.reset = function(){
        
        $scope.myForm.$setPristine(); //reset Form
    };
    
    

}]);