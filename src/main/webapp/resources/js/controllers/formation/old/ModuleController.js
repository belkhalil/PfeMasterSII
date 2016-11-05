App.controller('ModuleController', [
		'$scope',
		'ModuleService',
		'SemestreService',
		'MatiereService',
		'$http',
		'$q',
		function($scope, ModuleService, SemestreService, MatiereService, $http,
				$q) {
			var self = this;
			self.module = {
				idModule : null,
				nomModule : '',
				descModule : ''
			};
			self.moduleshow = {
				idModule : null,
				nomModule : '',
				descModule : ''
			};
			self.modules = [];
			self.semestres = [];
			self.matieres = [];
			$scope.showMe = false;
			self.idSelectedSemestre = '';
			self.idSelectedMatiere = '';

			self.getAllMatieres = function() {
				MatiereService.fetchAllMatieres().then(function(d) {
					self.matieres = d;
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.getAllsemestres = function() {
				SemestreService.fetchAllSemestre().then(function(d) {
					self.semestres = d;
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};
			// self.fetchAllModules = function() {
			// ModuleService.fetchAllModules().then(function(d) {
			// self.formations = d;
			// console.error('modules a inserer:' + self.modules);
			// }, function(errResponse) {
			// console.error('Error while fetching Currencies');
			// });
			// };

			self.getOneModule = function(id) {
				ModuleService.getOneModule(id).then(function(d) {
					self.moduleshow = d;
					console.log(self.moduleshow);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllModules = function() {
				ModuleService.fetchAllModules().then(function(d) {
					self.modules = d;

				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createModule = function() {
				ModuleService.createModule(self.module).then(
						function(d) {
							self.module = d;
							console.log(' id de module a ajouter:'
									+ self.module.idModule + ' au semestre '
									+ self.idSelectedSemestre);
							self.addModuleToSemestre(self.module.idModule,
									self.idSelectedSemestre);
							console.log(' id de matiere a ajouter:'
									+ self.idSelectedMatiere + ' au module '
									+ self.module.idModule);
							self.addMatiereToModule(self.idSelectedMatiere,
									self.module.idModule);
							self.fetchAllModules;
						}, function(errResponse) {
							console.error('Error while creating module.');
						});
			};

			self.updateModule = function(module, id) {
				ModuleService.updateModule(module, id).then(
						
						self.fetchAllModules, function(errResponse) {
							console.error('Error while updating module.');
						});
			};

			self.deleteModule = function(id) {
				ModuleService.deleteModule(id).then(self.fetchAllModules,
						function(errResponse) {
							console.error('Error while deleting module.');
						});
			};

			self.addModuleToSemestre = function(idM, idS) {
				ModuleService.addModuleToSemestre(idM, idS).then(function(d) {
					self.fetchAllModules();
					self.reset();
				}, function(errResponse) {
					console.error('Error while adding module to semestre.');
				});
			};

			self.addMatiereToModule = function(idMa, idMo) {
				ModuleService.addMatiereToModule(idMa, idMo).then(function(d) {
					self.fetchAllModules();
					self.reset();
				}, function(errResponse) {
					console.error('Error while adding matiere to module.');
				});
			};

			self.update = function() {
				console.log('updating d\'un module' + self.module.idModule);
				self.updateModule(self.module, self.module.idModule);
//				console.log(' id de module a ajouter:'
//						+ self.module.idModule + ' au semestre '
//						+ self.idSelectedSemestre);
				self.addModuleToSemestre(self.module.idModule,
						self.idSelectedSemestre);
				console.log(' id de matiere a ajouter:'
						+ self.idSelectedMatiere + ' au module '
						+ self.module.idModule);
				self.addMatiereToModule(self.idSelectedMatiere,
						self.module.idModule);
				self.fetchAllModules();
				
				self.reset();
			};

			self.add = function() {

				if (self.module.idModule === null) {

					self.createModule(self.module);

				} else {
					self.updateModule(self.module, self.module.idModule);
					console.log('formation updated with id ',
							self.module.idModule);
				}
				self.reset();

			};

			self.edit = function(id) {
				for (var i = 0; i < self.modules.length; i++) {
					if (self.modules[i].idModule == id) {
						self.module = angular.copy(self.modules[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteModule(id);
			};

			self.show = function(id) {
				self.getOneModule(id);
				$scope.showMe = !$scope.showMe;

			};

			self.reset = function() {
				self.module = {
					idModule : null,
					nomModule : '',
					descModule : ''
				};
				self.semestres = [];
				self.matieres = [];
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllModules();
			self.getAllsemestres();
			self.getAllMatieres();
		} ]);