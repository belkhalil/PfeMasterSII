

'use strict';
App.controller('EnsPController', ['$scope', 'EnsPService', function($scope, EnsPService) {
    var self = this;
    self.ensp={id:null,cin:'',firstName:'',lastName:'',password:'', adresseUtilisateur:'',email:''};
    self.enspshow={id:null,cin:'',firstName:'',lastName:'',password:'', adresseUtilisateur:'',email:''};
    self.ensps=[];
    $scope.showMe = false;
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
    
    
    self.createEnsp = function(){
    	EnsPService.createEnsp(self.ensp)
                .then(
                self.fetchEnsps, 
                        function(errResponse){
                             console.error('Error while creating ensp.');
                        } 
            );
    };

   self.updateEnsp = function(ensp, id){
	   EnsPService.updateEnsp(ensp, id)
                .then(
                        self.fetchEnsps, 
                        function(errResponse){
                             console.error('Error while updating ensp.');
                        } 
            );
    };

   self.deleteEnsp = function(id){
	   EnsPService.deleteEnsp(id)
                .then(
                        self.fetchEnsps, 
                        function(errResponse){
                             console.error('Error while deleting ensp.');
                        } 
            );
    };

    self.fetchEnsps();
    
    self.update = function(){
    	console.log('updating d\'un ensp'+self.ensp.id);
    	self.updateEnsp(self.ensp, self.ensp.id);
    	self.reset();
    };
    
    self.add=function(){
    	if(self.ensp.id===null){
            console.log('Saving New student', self.ensp);    
            self.createEnsp(self.ensp);
        }else{
            self.updateEnsp(self.ensp, self.ensp.id);
            console.log('ensp updated with id ', self.ensp.id);
        }
        self.reset();
    };
    
//    self.submit = function() {
//        if(self.etudiant.id===null){
//            console.log('Saving New student', self.etudiant);    
//            self.createEnsp(self.etudiant);
//        }else{
//            self.updateStudent(self.etudiant, self.etudiant.id);
//            console.log('student updated with id ', self.etudiant.id);
//        }
//        self.reset();
//    };
         
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
        self.deleteEnsp(id);
    };

     self.show=function(id){
    	 self.getOneEnsp(id);
    	 $scope.showMe = !$scope.showMe;
     };
     
    self.reset = function(){
        self.ensp={id:null,cin:'',firstName:'',lastName:'',password:'', adresseUtilisateur:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);