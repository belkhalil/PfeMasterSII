'use strict';

App.
	controller('MessageClasseController',
			['$scope','$http','$location' , '$window',
			function($scope, $http ,$location, $window, $filter) {
				//start				   
				var self = this;
				var classList = 'http://localhost:8080/classes/classes';
				var getClasse = 'http://localhost:8080/classes/getClasse/';
				var sendMessage = 'http://localhost:8080/classes/messagesClasse';
				var messagesClasse = 'http://localhost:8080/classes/messageClasseRecus';

			    $scope.htmlContent = '<h2> Testing Ecko </h2>!';
				
				self.idMessage = '';
				self.message = {
					id : '',
					objet : '',
					message : ''
				};
				
				self.idClasse = null;
				self.nomClasse = null;
				self.classe={idClasse:null,nomClasse:'',descClasse:'', nbrEtudiant:''};
				self.classes = [];
				self.messages = [];
				self.loadMessageClasse = function() {
					$http.get(messagesClasse).then(
							function(response) {
								self.messages = response.data;
								console.log('loading msg =>',self.messages);								
							}, function(errResponse) {
								console.log('fail to load msg classes');
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
	self.contacterClasse =function(id){
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
	self.contacter = function(id){	
		self.idClasse = id;
		self.getClasse(id);
		//self.message.email=email;
	};
	
	
	
	self.loadClasses();
	self.reset=function(){				
		self.classe={idClasse:null,nomClasse:'',descClasse:'', nbrEtudiant:''};
		self.idClasse = null;
		//self.message = null;
		
		self.message = {
			id : '',
			objet : '',
			message : ''
		};
	};
	self.loadMessageClasse();
	//end
}]);