'use strict';

App.
	controller('FichierClasseController',
			['$scope','$http','$location' , '$window',
			function($scope, $http ,$location, $window, $filter) {
				//start				   
				var self = this;
				var classList = 'http://localhost:8080/classes/classes';
				var getClasse = 'http://localhost:8080/empsi/getClasse/';
				var addFile = 'http://localhost:8080/classes/fichier';
				var listFile = 'http://localhost:8080/classes/mesFichiers/';
				var maClasse = 'http://localhost:8080/classes/maclasse/';
				self.idFichier = '';
				self.fichier = {
					idFichier : '',
					lienFichier : '',
					extension : '',
					nomFichier : ''
				};
				
				self.idClasse = null;
				self.nomClasse = null;
				self.classe=null;
				self.classes = [];
				self.files = null;
				self.getMaclasse = function(){
					$http.get(maClasse).then(
							function(response) {
								self.classe = response.data;
								console.log('Ma Classe',self.classe);
							}, function(errResponse) {
								console.log('fail to Load Students classes');
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
	
	// contacter les etudiants d'une classe
	self.partagerFichier =function(id){
		//self.classe = self.getClasse(id);
		self.getClasse(id);
		self.message.classe = self.classe;
		
		console.log('message ', self.message);

		$http
		.post(sendMessage,self.message)
		.success(
				function(data, status, headers,config) {
					self.message = data ;
					if(Object.keys(data).length === 0){
						console.log('Error', self.message);
						window.alert('Error');

					}else{	
					console.log('creating message ',self.message);
					
					window.alert('Message envoyees a la classe',id);
					}	
				})
		.error(function(data, status, headers,config) {
					console.error('no way an other error :');
				});
		$window.location.reload();
		//self.reset();
	};
	self.partager = function(id){	
		self.idClasse = id;
		self.getClasse(id);
		//self.message.email=email;
	};
	
	// un fichier
	self.loadFiles= function(id) {
		$http.get(listFile+'/'+id).then(
				function(response) {
					self.files = response.data;
				}, function(errResponse) {
					console.log('fail to load Sdeclarations');
				});
	};
	self.listerFichiers  = function(id){
		$http.get(listFile+id)
			.then(
				function(response) {
					self.files = response.data;
					console.log('Files in classe done => ',self.files);
				}, function(errResponse) {
					console.log('fail to Insert Object');
				});
		
	};	
	// getting classes
	self.loadClasses = function() {
		$http.get(classList).then(
				function(response) {
					self.classes = response.data;
					
				}, function(errResponse) {
					console.log('fail to load Sdeclarations');
				});
	};
	self.loadClasses();
	self.getMaclasse();
	//end
}]);