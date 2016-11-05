App.controller('MatiereController', [
		'$scope',
		'MatiereService',
		'ModuleService',
		'SemestreService',
		'$http',
		'$q',
		function($scope, MatiereService,ModuleService,SemestreService, $http, $q) {
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
			self.semestres = [];
			self.idSelectedSemestre=null;
			self.idSelectedModule=null;
			self.Modules= [];
			
			self.fetchAllSemestre = function() {
				SemestreService.fetchAllSemestre().then(function(d) {
					self.semestres = d;
					console.error('fetching all semestres');
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};
			
			self.fetchAllModules = function() {
				ModuleService.fetchAllModules().then(function(d) {
					self.Modules = d;
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

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
							self.matiere = d;
							console.log(' id de matiere a ajouter:'
									+ self.matiere.idMatiere);
						//self.addMatiereToSemestre(self.matiere.idMatiere,self.idSelectedSemestre);
							
				console.log('ajouter la matiere :'+ self.matiere.idMatiere+'au module'+ self.idSelectedModule );
						self.addMatiereToModule(self.matiere.idMatiere, self.idSelectedModule);
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

//			 self.addMatiereToSemestre = function(idM, idS) {
//			 MatiereService.addMatiereToSemestre(idM, idS).then(function(d) {
//			 self.fetchAllMatieres();
//			 self.reset();
//			 }, function(errResponse) {
//			 console.error('Error while adding formation.');
//			 });
//			 };
//			 
			 self.addMatiereToModule = function(idMa, idMo) {
					ModuleService.addMatiereToModule(idMa, idMo).then(function(d) {
						self.fetchAllMatieres();
						self.reset();
					}, function(errResponse) {
						console.error('Error while adding matiere to module.');
					});
				};

			self.update = function() {
				console.log('updating d\'un matiere' + self.matiere.idMatiere);
				self.updateMatiere(self.matiere, self.matiere.idMatiere);
				
				self.fetchAllMatieres();
				
				self.reset();
				$scope.showMe=false;
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
				$scope.showMe=false;
			};

			self.edit = function(id) {
				for (var i = 0; i < self.matieres.length; i++) {
					if (self.matieres[i].idMatiere == id) {
						self.matiere = angular.copy(self.matieres[i]);
						break;
					}
				}
				$scope.showMe=false;
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteMatiere(id);
				$scope.showMe=false;
			};

			self.show = function(id) {
				self.getOneMatiere(id);
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
				self.matiere = {
					idMatiere : null,
					nomMatiere : '',
					description : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllMatieres();
			//self.fetchAllSemestre();
			self.fetchAllModules();

		} ]);