


'use strict';
App.controller('EtudiantController', ['$scope', 'EtudiantService', function($scope, EtudiantService) {
    var self = this;
    self.etudiant={id:null,cin:'',cne:'',firstName:'',lastName:'',dateNaissance:'',password:'', adresseUtilisateur:'',email:''};
    self.etudiantshow={id:null,cin:'',cne:'',firstName:'',lastName:'',dateNaissance:'',password:'', adresseUtilisateur:'',email:''};
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
    	console.log('updating d\'un etudiant'+self.etudiant.id);
    	self.updateStudent(self.etudiant, self.etudiant.id);
    	self.reset();
    };
    
    self.add=function(){
    	if(self.etudiant.id===null){
            console.log('Saving New student', self.etudiant);
         // 
            var st1=self.etudiant.dateNaissance;
            var dateN = new Date(st1);
            
            self.etudiant.dateDebut=dateN;
            
            self.createStudent(self.etudiant);
        }else{
            self.updateStudent(self.etudiant, self.etudiant.id);
            console.log('student updated with id ', self.etudiant.id);
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
            if(self.etudiants[i].id == id) {
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
        self.etudiant={id:null,cin:'',cne:'',firstName:'',lastName:'',dateNaissance:'',password:'', adresseUtilisateur:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);

App.directive('equalsTo', [function () {
	
    /*
    * <input type="password" ng-model="Password" />
    * <input type="password" ng-model="ConfirmPassword" equals-to="Password" />
    */
    return {
        restrict: 'A', // S'utilise uniquement en tant qu'attribut
        scope: true,
        require: 'ngModel',
        link: function (scope, elem, attrs, control) {
            var check = function () {
            //Valeur du champs courant 
            var v1 = scope.$eval(attrs.ngModel); // attrs.ngModel = "ConfirmPassword"
            //valeur du champ à comparer
            var v2 = scope.$eval(attrs.equalsTo).$viewValue; // attrs.equalsTo = "Password"
            return v1 == v2;
        };
        scope.$watch(check, function (isValid) {
            // Défini si le champ est valide
            control.$setValidity("equalsTo", isValid);
        });
    }
};
}]);