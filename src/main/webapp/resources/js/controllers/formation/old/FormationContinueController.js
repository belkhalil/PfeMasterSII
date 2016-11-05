
'use strict';

App.controller('formationContinueController', ['$scope', 'FormationService', function($scope, FormationService) {
    var self = this;
    self.formation={idFormation:null,nomFormation:'',dateDebut:'',dateFin:'',descFormation:'',prix:'',dure:''};
    self.formationshow={idFormation:null,nomFormation:'',dateDebut:'',dateFin:'',descFormation:'',prix:'',dure:''};
    self.formations=[];
    $scope.showMe = false;
    self.getOneFormation = function(id){
    	FormationService.getOneFormation(id)
    	 .then(
                function(d) {
                     self.formationshow = d;
                     console.log(self.formationshow);
                },
                 function(errResponse){
                     console.error('Error while fetching Currencies');
                 }
        );
    };
    
    self.fetchAllFormations = function(){
    	FormationService.fetchAllFormations()
            .then(
                         function(d) {
                              self.formations = d;
                              
                              console.error('formation a inserer:'+ self.formations); 
                         },
                          function(errResponse){
                              console.error('Error while fetching Currencies');
                          }
                 );
    };
    
    
      
    self.createFormation = function(){
    	FormationService.createFormation(self.formation)
                .then(
                self.fetchAllFormations, 
                        function(errResponse){
                             console.error('Error while creating formation.');
                        } 
            );
    };

   self.updateFormation = function(formation, id){
	   FormationService.updateFormation(formation, id)
                .then(
                        self.fetchAllFormations, 
                        function(errResponse){
                             console.error('Error while updating formation.');
                        } 
            );
    };

   self.deleteFormation = function(id){
	   FormationService.deleteFormation(id)
                .then(
                        self.fetchAllFormations, 
                        function(errResponse){
                             console.error('Error while deleting formation.');
                        } 
            );
    };

    self.fetchAllFormations();
    
    self.update = function(){
    	console.log('updating d\'une formation'+self.formation.idFormation);
    	
       	self.updateFormation(self.formation,self.formation.idFormation);
    	self.reset();
    };
    
    self.add=function(){
    	if(self.formation.idFormation===null){
            
         // convertion de date de string a date
            var st2=self.formation.dateFin;
            var st1=self.formation.dateDebut;
            console.log('date old '+self.formation.dateFin);
            var dateF = new Date(st2);
            var dateD = new Date(st1);
            dateF = new Date(dateF.getTime() + 86400000);
            dateD = new Date(dateD.getTime() + 86400000);
            console.log(' formation newwwwwww '+dateF);
            self.formation.dateFin=dateF;
            self.formation.dateDebut=dateD;
         
            self.createFormation(self.formation);
        }else{
            self.updateFormation(self.formation, self.formation.idFormation);
            console.log('formation updated with id ', self.formation.idFormation);
        }
        self.reset();
    };
    
// self.submit = function() {
// if(self.formation.id===null){
// console.log('Saving New formation', self.formation);
// self.createFormation(self.formation);
// }else{
// self.updateFormation(self.formation, self.formation.id);
// console.log('formation updated with id ', self.formation.id);
// }
// self.reset();
// };
         
    self.edit = function(id){
        for(var i = 0; i < self.formations.length; i++){
            if(self.formations[i].idFormation == id) {
               self.formation = angular.copy(self.formations[i]);
               break;
            }
        }
    };
         
    self.remove = function(id){
        console.log('id to be deleted', id);
        self.deleteFormation(id);
    };

     self.show=function(id){
    	 self.getOneFormation(id);
    	 $scope.showMe = !$scope.showMe;
     };
     
    self.reset = function(){
        self.formation={idFormation:null,nomFormation:'',dateDebut:'',dateFin:'',descFormation:'',prix:'',dure:''};
        $scope.myForm.$setPristine(); // reset Form
    };

}]);