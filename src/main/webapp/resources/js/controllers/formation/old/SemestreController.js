App.controller('SemestreController', [
		'$scope',
		'SemestreService',
		'SemestreService',
		'$http',
		'$q',
		function($scope, SemestreService, SemestreService, $http,$q) {
			var self = this;
			self.semestre = {
				idSemestre : null,
				dateDebut : '',
				dateFin : '',
				description : ''
			};
			self.semestreshow = {
					idSemestre : null,
					dateDebut : '',
					dateFin : '',
					description : ''
			};
			self.semestres = [];
			
			$scope.showMe = false;

			self.fetchAllSemestre = function() {
				SemestreService.fetchAllSemestre().then(function(d) {
					self.formations = d;
					console.error('semestres a inserer:' + self.semestres);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.getOneSemestre = function(id) {
				SemestreService.getOneSemestre(id).then(function(d) {
					self.semestreshow = d;
					console.log(self.semestreshow);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllSemestre = function() {
				SemestreService.fetchAllSemestre().then(function(d) {
					self.semestres = d;

				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createSemestre = function() {
				SemestreService.createSemestre(self.semestre)
				.then(
						function(d) {
							self.semestre = d;
			                //console.log(' id de semestre a ajouter:'+ self.idSemestre+' au semestre '+self.semestre.idSemestre);
			                //self.addFornationToNiveau(self.idformation,self.niveau.idNiveau);
							self.fetchAllSemestre;
							
						}, function(errResponse) {
							console.error('Error while creating semestre.');
						});
			};


			self.updateSemestre = function(semestre, id) {
				SemestreService.updateSemestre(semestre, id).then(
						self.fetchAllSemestre, function(errResponse) {
							console.error('Error while updating semestre.');
						});
			};

			self.deleteSemestre = function(id) {
				SemestreService.deleteSemestre(id).then(self.fetchAllSemestre,
						function(errResponse) {
							console.error('Error while deleting semestre.');
						});
			};

//			self.addFornationToNiveau = function(idF, idN) {
//				SemestreService.addFormationToNiveau(idF, idN).then(function(d) {
//					self.fetchAllSemestre(); 
//					self.reset();
//				},function(errResponse) {
//							console.error('Error while adding formation.');
//						});
//			};

			self.update = function() {
				console.log('updating d\'un Semestre' + self.semestre.idSemestre);
				self.updateSemestre(self.semestre, self.semestre.idSemestre);
				
				//self.addFornationToNiveau(self.idformation,self.niveau.idNiveau);
				self.fetchAllSemestre();
				//self.fetchAllFormations();
				self.reset();
			};
			
	
			
			self.add = function() {
				
				if(self.semestre.idSemestre===null){
		            
			         // convertion de date de string a date
			            var st2=self.semestre.dateFin;
			            var st1=self.semestre.dateDebut;
			            console.log('date old '+self.semestre.dateFin);
			            var dateF = new Date(st2);
			            var dateD = new Date(st1);
			            dateF = new Date(dateF.getTime() + 86400000);
			            dateD = new Date(dateD.getTime() + 86400000);
			            console.log(' semestre  newwwwwww '+dateF);
			            self.semestre.dateFin=dateF;
			            self.semestre.dateDebut=dateD;
			            
			            self.createSemestre(self.semestre);
			            
			           
			        }else{
			        	self.updateSemestre(self.semestre, self.semestre.idSemestre);
			            console.log('formation updated with id ', self.semestre.idSemestre);
			        }
				 self.reset();
				    
			};

			self.edit = function(id) {
				for (var i = 0; i < self.semestres.length; i++) {
					if (self.semestres[i].idSemestre == id) {
						self.semestre = angular.copy(self.semestres[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteSemestre(id);
			};

			self.show = function(id) {
				self.getOneSemestre(id);
				$scope.showMe = !$scope.showMe;

			};

			self.reset = function() {
				self.semestre = {
						idSemestre : null,
						dateDebut : '',
						dateFin : '',
						description : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllSemestre();
			
		} ]);