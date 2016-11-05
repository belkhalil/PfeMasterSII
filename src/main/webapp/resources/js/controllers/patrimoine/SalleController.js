App.controller('SalleController', [
		'$scope',
		'SalleService',
		'$http',
		'$q',
		function($scope, SalleService, $http, $q) {
			var self = this;
			self.salle = {
				idSalle : null,
				numSalle : null,
				typeSalle : '',
				descSalle : ''
			};
			self.salleshow = {
				idSalle : null,
				numSalle : null,
				typeSalle : '',
				descSalle : ''
			};
			self.salles = [];
			$scope.showMe = false;
			self.etatdeSalle = [],

			self.getOneSalle = function(id) {
				SalleService.getOneSalle(id).then(function(d) {
					self.salleshow = d;
					console.log(self.salleshow);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllSalles = function() {
				SalleService.fetchAllSalles().then(
						function(d) {
							self.salles = d;
							/*// l'etat de la salle
							for (var i = 0; i < self.salles.length; i++) {
								console.log("eta des salles "
										+ self.salles[i].idSalle
										+ "------------"
										+ self.salles[i].etatSalle);
								if (self.salles[i].etatSalle === true) {
									self.salles[i].labelEtat = 'reserver';
								} else  {
									self.salles[i].labelEtat = 'libre';
								}
							};*/

						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			self.createSalle = function() {
				SalleService.createSalle(self.salle).then(
						function(d) {
							self.salle = d;
							console.log(' id de salle a ajouter:'
									+ self.salle.idSalle);
							// self.etatSalle(self.salle.etatSalle);
							console.log(' etat de salle a ajouter:'
									+ self.etatdeSalle);
							self.fetchAllSalles();
						}, function(errResponse) {
							console.error('Error while creating salle.');
						});
			};

			self.updateSalle = function(salle, id) {
				SalleService.updateSalle(salle, id).then(self.fetchAllSalles,
						function(errResponse) {
							console.error('Error while updating salle.');
						});
			};

			self.deleteSalle = function(id) {
				SalleService.deleteSalle(id).then(self.fetchAllSalles,
						function(errResponse) {
							console.error('Error while deleting salle.');
						});
			};

			self.update = function() {
				console.log('updating d\'un salle' + self.salle.idSalle);
				self.updateSalle(self.salle, self.salle.idSalle);

				self.fetchAllSalles();
				self.reset();
			};

			self.add = function() {
				if (self.salle.idSalle === null) {
					self.createSalle(self.salle);
				} else {
					self.updateSalle(self.salle, self.salle.idSalle);
					console.log('formation updated with id ',
							self.salle.idSalle);
				}
				self.reset();
				$scope.showMe=false;
			};

			self.edit = function(id) {
				for (var i = 0; i < self.salles.length; i++) {
					if (self.salles[i].idSalle == id) {
						self.salle = angular.copy(self.salles[i]);
						break;
					}
				}
				$scope.showMe=false;
			};

			self.remove = function(id) {
				
				console.log('id to be deleted', id);
				self.deleteSalle(id);
				$scope.showMe=false;
				
			};

			// self.etatSalle = function(etat) {
			// if (etat === false) {
			// self.etatdeSalle = 'libre';
			// } else {
			// self.etatdeSalle = 'reserver';
			// }
			// };
			self.show = function(id) {
				self.getOneSalle(id);
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
				self.salle = {
					idSalle : null,
					numSalle : null,
					typeSalle : '',
					descSalle : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllSalles();
		} ]);