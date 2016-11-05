'use strict';

App.
	controller('ClasseController',
			['$scope','$http','$location' ,
			function($scope, $http ,$location, $window, $filter) {
				//start				   
				var self = this;
				var addClasse = 'http://localhost:8080/classes/classes';
				var classList = 'http://localhost:8080/classes/classes';
				var deleteClasse = 'http://localhost:8080/classes/deleteClasse/';
				var getClasse = 'http://localhost:8080/classes/getClasse/';
				var anneeList = 'http://localhost:8080/classes/annees';
				var getAnnee = 'http://localhost:8080/classes/getAnnee/';
				//gestion des classes et etudiants
				var getFormation = 'http://localhost:8080/classes/getFormation/';
				var addStudentToClass = 'http://localhost:8080/classes/addEtudiantToClass/';
				var students = 'http://localhost:8080/classes/students/';
				var getStudent = 'http://localhost:8080/classes/student/';
				var adding =  'http://localhost:8080/classes/adding/';
				var getInscriptions = 'http://localhost:8080/classes/getInscriptions/';
				
				self.idClasse = '';
				self.classe={idClasse:null,nomClasse:'',descClasse:'', nbrEtudiant:''};
			    self.anneScolaire = {idAnne:null,anneeDebut:'',anneeFin:'',descAnnee:''};
				self.annees = [];
				self.classes = [];
				self.idAnne= 0;
				
				self.inscriptions = [];
				self.etudiants = [];
				self.etudiant = {};
				self.idEtudiant = 0;
				self.idClasse = 1;
				
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
			 //console.log(id);
			 //window.alert('wak wak a 3ibad allah');
			 $location.url('classeDetail/'+id);
		};
				
	
	//liste des inscriptions			
	self.getInsc = function(){
		$http.get(getInscriptions).then(
				function(response) {
					self.inscriptions = response.data;
					console.log('Les inscriptions',self.inscriptions);
				}, function(errResponse) {
					console.log('fail to Load Students List');
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
	self.addStudentToClasse  = function(id , id2){
		$http.get(addStudentToClass+id+'/'+id2)
			.then(
				function(response) {
					console.log('Student in classe done => ');
				}, function(errResponse) {
					console.log('fail to Insert Object');
				});
		
	};
	// contacter les etudiants d'une classe
	self.contacterClasse =function(id){
		self.getClasse(id);
		
		$http
		.post(sendMessage,self.message)
		.success(
				function(data, status, headers,config) {
					self.message = data ;
					if(Object.keys(data).length === 0){
						console.log('Invalid Email', self.message);
						window.alert('Email nom valide');

					}else{	
					console.log('creating message ',self.message);
					
					window.alert('Message envoyees a la classe',id);
					}	
				})
		.error(function(data, status, headers,config) {
					console.error('no way an other error :');
				});
	};
	self.getInsc();
	self.loadClasses();
	self.getAnnees();
	self.reset=function(){				
		self.classe={idClasse:null,nomClasse:'',descClasse:'', nbrEtudiant:''};
	    self.anneScolaire = {idAnne:null,anneeDebut:'',anneeFin:'',descAnnee:''};
		self.idAnne = 0;
	};
	//end
}]);