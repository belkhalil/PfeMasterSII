App.controller('MaterielController', [
		'$scope',
		'MaterielService',
		'$http',
		'$q',
		function($scope, MaterielService, $http, $q) {
			var self = this;
			self.materiel = {
				idMateriel : null,
				nomMateriel : '',
				matricule : '',
				description : ''
			};
			self.materielshow = {
				idMateriel : null,
				nomMateriel : '',
				matricule : '',
				description : ''
			};
			self.materiels = [];
			$scope.showMe = false;
			self.etatdeMateriel = [],

			self.getOneMateriel = function(id) {
				MaterielService.getOneMateriel(id).then(function(d) {
					self.materielshow = d;
					console.log(self.materielshow);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllMateriels = function() {
				MaterielService.fetchAllMateriels().then(
						function(d) {
							self.materiels = d;
							// l'etat de la materiel
							/*for (var i = 0; i < self.materiels.length; i++) {
								console.log("eta des materiels "
										+ self.materiels[i].idMateriel
										+ "------------"
										+ self.materiels[i].etat);
								if (self.materiels[i].etat === true) {
									self.materiels[i].labelEtat = 'reserver';
								} else {
									self.materiels[i].labelEtat = 'libre';
								}
							}
							;*/

						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			self.createMateriel = function() {
				MaterielService.createMateriel(self.materiel).then(
						function(d) {
							self.materiel = d;
							console.log(' id de materiel a ajouter:'
									+ self.materiel.idMateriel);

							self.fetchAllMateriels();
							self.reset();
						}, function(errResponse) {
							console.error('Error while creating materiel.');
						});
			};

			self.updateMateriel = function(materiel, id) {
				MaterielService.updateMateriel(materiel, id).then(
						self.fetchAllMateriels, function(errResponse) {
							console.error('Error while updating materiel.');
						});
			};

			self.deleteMateriel = function(id) {
				MaterielService.deleteMateriel(id).then(self.fetchAllMateriels,
						function(errResponse) {
							console.error('Error while deleting materiel.');
						});
			};

			self.update = function() {
				console.log('updating d\'un materiel'
						+ self.materiel.idMateriel);
				self.updateMateriel(self.materiel, self.materiel.idMateriel);

				self.fetchAllMateriels();
				self.reset();
			};

			self.add = function() {
				if (self.materiel.idMateriel === null) {
					self.createMateriel(self.materiel);
					} else {
					self.updateMateriel(self.materiel,
									self.materiel.idMateriel);
					console.log('materiel updated with id ',
							self.materiel.idMateriel);
				}
				self.reset();
				$scope.showMe=false;
			};
			
			

			self.edit = function(id) {
				for (var i = 0; i < self.materiels.length; i++) {
					if (self.materiels[i].idMateriel == id) {
						self.materiel = angular.copy(self.materiels[i]);
						break;
					}
				}
				$scope.showMe=false;
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteMateriel(id);
				$scope.showMe=false;
			};

			self.show = function(id) {
				self.getOneMateriel(id);
				//$scope.showMe = !$scope.showMe;
				if($scope.showMe===true)
				{
				$scope.showMe=$scope.showMe;
				}
			else{
				$scope.showMe=!$scope.sowMe;
				}
			};

			self.reset = function() {
				self.materiel = {
						idMateriel : null,
						nomMateriel : '',
						matricule : '',
						description : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllMateriels();
		} ]);