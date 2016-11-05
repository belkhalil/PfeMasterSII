


'use strict';
App.controller('EtudiantController', ['$scope', 'EtudiantService', function($scope, EtudiantService) {
    var self = this;
    self.etudiant={idUtilisateur:null,cinUtilisateur:'',cne:'',nomUtilisateur:'',prenomUtilisateur:'',dateNaissance:'', adresseUtilisateur:'',emailUtilisateur:''};
    self.etudiantshow={idUtilisateur:null,cinUtilisateur:'',cne:'',nomUtilisateur:'',prenomUtilisateur:'',dateNaissance:'', adresseUtilisateur:'',emailUtilisateur:''};
    self.etudiants=[];
    $scope.showMe = false;
    self.getOneStudent = function(id){
    	EtudiantService.getOneStudent(id)
    	 .then(
                function(d) {
                     self.etudiantshow = d;
                     console.log(self.etudiantshow);
                },
                 function(errResponse){
                     console.error('Error while fetching Currencies');
                 }
        );
    };
    
    self.fetchAllStudents = function(){
    	EtudiantService.fetchAllStudents()
            .then(
                         function(d) {
                              self.etudiants = d;
                              
                         },
                          function(errResponse){
                              console.error('Error while fetching Currencies');
                          }
                 );
    };
    
    
      
    self.createStudent = function(){
    	EtudiantService.createStudent(self.etudiant)
                .then(
                self.fetchAllStudents, 
                        function(errResponse){
                             console.error('Error while creating User.');
                        } 
            );
    };

   self.updateStudent = function(etudiant, id){
	   EtudiantService.updateStudent(etudiant, id)
                .then(
                        self.fetchAllStudents, 
                        function(errResponse){
                             console.error('Error while updating User.');
                        } 
            );
    };

   self.deleteStudent = function(id){
	   EtudiantService.deleteStudent(id)
                .then(
                        self.fetchAllStudents, 
                        function(errResponse){
                             console.error('Error while deleting student.');
                        } 
            );
    };

    self.fetchAllStudents();
    
    self.update = function(){
    	console.log('updating d\'un etudiant'+self.etudiant.idUtilisateur);
    	self.updateStudent(self.etudiant, self.etudiant.idUtilisateur);
    	self.reset();
    };
    
    self.add=function(){
    	if(self.etudiant.idUtilisateur===null){
            console.log('Saving New student', self.etudiant);
         // 
            var st1=self.etudiant.dateNaissance;
            var dateN = new Date(st1);
            
            self.etudiant.dateDebut=dateN;
            
            self.createStudent(self.etudiant);
        }else{
            self.updateStudent(self.etudiant, self.etudiant.idUtilisateur);
            console.log('student updated with id ', self.etudiant.idUtilisateur);
        }
        self.reset();
    };
    
//    self.submit = function() {
//        if(self.etudiant.id===null){
//            console.log('Saving New student', self.etudiant);    
//            self.createStudent(self.etudiant);
//        }else{
//            self.updateStudent(self.etudiant, self.etudiant.id);
//            console.log('student updated with id ', self.etudiant.id);
//        }
//        self.reset();
//    };
         
    self.edit = function(id){
        for(var i = 0; i < self.etudiants.length; i++){
            if(self.etudiants[i].idUtilisateur == id) {
               self.etudiant = angular.copy(self.etudiants[i]);
               break;
            }
        }
    };
         
    self.remove = function(id){
        console.log('id to be deleted', id);
        self.deleteStudent(id);
    };

     self.show=function(id){
    	 self.getOneStudent(id);
    	 $scope.showMe = !$scope.showMe;
     };
     
    self.reset = function(){
        self.etudiant={idUtilisateur:null,cinUtilisateur:'',cne:'',nomUtilisateur:'',prenomUtilisateur:'',dateNaissance:'', adresseUtilisateur:'',emailUtilisateur:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);