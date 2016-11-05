App.controller('MatiereController', [
		'$scope',
		'MatiereService',

		'$http',
		'$q',
		function($scope, MatiereService, $http, $q) {
			var self = this;
			self.matiere = {
				idMatiere : null,
				nomMatiere : '',
				description : ''
			};
			self.matiereshow = {
				idMatiere : null,
				nomMatiere : '',
				description : ''
			};
			self.matieres = [];
			$scope.showMe = false;

			self.getOneMatiere = function(id) {
				MatiereService.getOneMatiere(id).then(function(d) {
					self.matiereshow = d;
					console.log(self.matiereshow);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllMatieres = function() {
				MatiereService.fetchAllMatieres().then(function(d) {
					self.matieres = d;
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createMatiere = function() {
				MatiereService.createMatiere(self.matiere).then(
						function(d) {
							//self.matiere = d;
							console.log(' id de matiere a ajouter:'
									+ self.matiere.idMatiere);
							// self.addmatiereToSemestre(self.matiere.idMatiere,self.idSelectedSemestre);
							self.fetchAllMatieres();
						}, function(errResponse) {
							console.error('Error while creating matiere.');
						});
			};

			self.updateMatiere = function(matiere, id) {
				MatiereService.updateMatiere(matiere, id).then(
						self.fetchAllMatieres, function(errResponse) {
							console.error('Error while updating matiere.');
						});
			};

			self.deleteMatiere = function(id) {
				MatiereService.deleteMatiere(id).then(self.fetchAllMatieres,
						function(errResponse) {
							console.error('Error while deleting matiere.');
						});
			};

			// self.addmatiereToSemestre = function(idM, idS) {
			// MatiereService.addmatiereToSemestre(idM, idS).then(function(d) {
			// self.fetchAllMatieres();
			// self.reset();
			// }, function(errResponse) {
			// console.error('Error while adding formation.');
			// });
			// };

			self.update = function() {
				console.log('updating d\'un matiere' + self.matiere.idMatiere);
				self.updateMatiere(self.matiere, self.matiere.idMatiere);
				// self.addFornationToNiveau(self.idformation,self.niveau.idNiveau);
				self.fetchAllMatieres();
				// self.fetchAllFormations();
				self.reset();
			};

			self.add = function() {
				if (self.matiere.idMatiere === null) {
					self.createMatiere(self.matiere);
				} else {
					self.updateMatiere(self.matiere, self.matiere.idMatiere);
					console.log('formation updated with id ',
							self.matiere.idMatiere);
				}
				self.reset();
			};

			self.edit = function(id) {
				for (var i = 0; i < self.matieres.length; i++) {
					if (self.matieres[i].idMatiere == id) {
						self.matiere = angular.copy(self.matieres[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteMatiere(id);
			};

			self.show = function(id) {
				self.getOneMatiere(id);
				$scope.showMe = !$scope.showMe;
			};

			self.reset = function() {
				self.matiere = {
					idMatiere : null,
					nomMatiere : '',
					description : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllMatieres();

		} ]);