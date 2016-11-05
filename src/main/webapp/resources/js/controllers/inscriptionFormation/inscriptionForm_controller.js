'use strict';

App.
	controller('InscriptionFormationController',
			['$scope','$http','$location',
			function($scope, $http , $location) {
				//start				   
				var self = this;
				var getTypes = 'http://localhost:8080/formation/typeFormations';
				var getFormByType = 'http://localhost:8080/formation/formationsByType/';
				var getFormat = 'http://localhost:8080/formation/loadForm/';
				var saveInsc = 'http://localhost:8080/classes/inscription/';
				$scope.ff = {};
				self.idFichier = '';
				self.inscription = {};
				self.types = [];
				self.formations = [];
				self.form = {};
				self.id = 'insc';
				self.fichier = {
					idFichier : '',
					lienFichier : '',
					extension : '',
					nomFichier : ''
				};
				self.idFormation = null;
	
	// getting Classe Object
	self.getFormations = function(id){
		$http.get(getFormByType+id).then(
				function(response) {
					self.formations = response.data;
					console.log('Liste des formations => ',self.formations);
				}, function(errResponse) {
					console.log('fail to Classe Object');
				});
		
	};
	
	// contacter les etudiants d'une classe
	self.submit =function(id){
		var id2 = id.idFormation;
		$http.get(getFormat+id2).then(
				function(response) {
					self.inscription.formation = response.data;
					console.log('Classe formation => ',self.inscription.formation);
					
		$http
		.post(saveInsc,self.inscription)
		.success(
				function(data, status, headers,config) {
					self.inscription = data ;
					if(Object.keys(data).length === 0){
						console.log('Error', self.inscription);
						window.alert('Error');

					}else{	
					console.log('INSC => ',self.inscription);
					self.id='fait';
					window.alert('insription effectue avec succes');
					
					}	
				})
		.error(function(data, status, headers,config) {
					console.error('no way an other error :');
				});
		//$window.location.reload();
		//self.reset();*/
				});
	};

	///
	self.changeFormation = function(id){
		console.log('====>',id);
		self.getFormations(id.idTypeFormation);
		//self.message.email=email;
	};
	
	self.loadTypes = function() {
		$http.get(getTypes).then(
				function(response) {
					self.types = response.data;
					console.log(' Types',self.types);
					
				}, function(errResponse) {
					console.log('fail to load Types');
				});
	};
	self.getFormation = function(id) {
		$http.get(getForm+id).then(
				function(data) {
					self.form = data;

					console.log(' Formation ID => ',id);
					console.log(' Formation ID => ',data);
					console.log(' Formation ID => ',self.form);
				});
	};
	
	self.getF = function(id){
		$http.get(getFormat+id).then(
				function(response) {
					$scope.ff = response.data;
					
					console.log('Classe formation => ',$scope.ff);
				
				});
		
	};
	
	
	self.loadTypes();
	//end
}]);