'use strict';

App.
	controller('MaClasseController',
			['$scope','$http','$location' ,
			function($scope, $http ,$location, $window, $filter) {
				//start				   
				var self = this;
				
				var getClasse = 'http://localhost:8080/getClasse/';
				var getAnnee = 'http://localhost:8080/getAnnee/';
				//gestion des classes et etudiants
				
				var maClasse = 'http://localhost:8080/classes/maclasse/';
				var getStudents = 'http://localhost:8080/classes/getStudents/';
				var sendMessage = 'http://localhost:8080/message/messages';

				self.etudiants = null;
				self.etudiant = {};
				self.idClasse = 1;
				self.email = null;
				
				self.classe=null;
				self.annees = [];
				self.classes = null;
				self.idAnne= 0;
				

				self.idEtudiant = 0;
				
				// contact Etudiant de la classe
				self.idMessage = '';
				self.message = {
					id : '',
					objet : '',
					message : '',
					email : '',
					email_sender : ''
				};
				self.addMessage =function(){	
					$http
					.post(sendMessage,self.message)
					.success(
							function(data, status, headers,config) {
								self.message = data ;
								console.log('creating message ',self.message);
								window.alert('Message envoyee');
							})
					.error(function(data, status, headers,config) {
								console.error('no way an other error :');
							});
				};
				self.contacter = function(email){	
					self.email = email;
					self.message.email=email;
				};
				
				//liste de mes classes			
				self.getMaclasse = function(){
					$http.get(maClasse).then(
							function(response) {
								self.classe = response.data;
								console.log('Ma Classe',self.classe);
							}, function(errResponse) {
								console.log('fail to Load Students classes');
							});
				};
				// getting Classe Object
				self.getClasse = function(id){
					$http.get(getClasse+id).then(
							function(response) {
								self.classe = response.data;
								console.log('Classe => ',self.classe);
							}, function(errResponse) {
								console.log('fail to Classe Object');
							});
					
				};
				// getting Student Object
				self.getStudent = function(id){
					$http.get(getStudent+id).then(
							function(response) {
								self.etudiant= response.data;
								console.log('Student => ',self.etudiant);
							}, function(errResponse) {
								console.log('fail to Student Object');
							});
					
				};
				self.listerStudents  = function(id){
					$http.get(getStudents+id)
						.then(
							function(response) {
								self.etudiants= response.data;
								console.log('Students in classe done => ',self.etudiants);
							}, function(errResponse) {
								console.log('fail to Insert Object');
							});
					
				};				
				
				
				
				
				
				
				self.getAnnees = function () {
					$http.get(anneeList).then(
							function(response) {
								self.annees = response.data;
								console.log('Anneees',self.annees);
							}, function(errResponse) {
								console.log('fail to load Annees Scolaire');
							});
				};
				
				self.addclasse =function(id){
					
					$http.get(getAnnee+id).then(
							function(response) {
								self.classe.anneScolaire = response.data;
								console.log('Anneee Scolaire => ',self.classe.anneScolaire);
								
								$http
								.post(addClasse,self.classe)
								.success(
										function(data, status, headers,config) {
											//self.classe = data ;
											console.log('creating classe ',self.classe);
											self.loadClasses();
											window.alert('Class Created');
										})
								.error(function(data, status, headers,config) {
											console.error('no way an other error :');
										});
								
							}, function(errResponse) {
								console.log('fail to load Annees Scolaire');
								return null;
							});
				};
		
				self.loadClasses = function() {
					$http.get(classList).then(
							function(response) {
								self.classes = response.data;
								
							}, function(errResponse) {
								console.log('fail to load Sdeclarations');
							});
				};

				self.supprimer = function(id) {
					$http
							.get(deleteClasse + id)
							.then(
									function(response) {
										self.loadClasses();
									},
									function(errResponse) {
										console
												.log('fashlat fi delete allah iarza9 salama'
														+ errResponse);
									});

				};
				/*self.search=function(){
					var tempUsers=[];
					for (var int = 0; int <self.oldusers.length; int++) {
						var search_element = self.oldusers[int].firstName;
						if (search_element.toLowerCase().indexOf(self.nameForSearch) >= 0) {
							tempUsers.push(angular.copy(self.oldusers[int]));
						};
					}
					self.users=tempUsers;
				};*/
				self.getClasseDetail=function(id){
					console.log(id);
					 $location.url('classeDetail/'+id);
				};
	
	self.getMaclasse();
	self.reset=function(){				
		self.classe={idClasse:null,nomClasse:'',descClasse:'', nbrEtudiant:''};
		self.idAnne = 0;
	};
	//end
}]);