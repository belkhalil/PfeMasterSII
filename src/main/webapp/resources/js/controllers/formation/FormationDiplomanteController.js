App.controller(
				'formationDiplomanteController',
				[
						'$scope',
						'FormationDService',
						'typeFormationService',
						function($scope, FormationDService,
								typeFormationService) {
							var self = this;
							self.formation = {
								idFormation : null,
								nomFormation : '',
								dateDebut : '',
								dateFin : '',
								descFormation : '',
								dure : ''
							};
							self.formationshow = {
								idFormation : null,
								nomFormation : '',
								dateDebut : '',
								dateFin : '',
								descFormation : '',
								dure : ''
							};
							self.formations = [];
							self.typeFormations = [];
							self.idSelectedType = null;
							self.idOldType= null;
						    self.showMe = false;
							self.getOneFormation = function(id) {
								FormationDService
										.getOneFormation(id)
										.then(function(d) {
													self.formationshow = d;
													console.log(self.formationshow);
												},
												function(errResponse) {
													console
															.error('Error while fetching Currencies');
												});
							};

							self.fetchAllFormations = function() {
								FormationDService
										.fetchAllFormations()
										.then(function(d) 
											{
											self.formations = d;

												},
												function(errResponse) {
													console.error('Error while fetching Currencies');
												});
							};

							self.getAlltypeFormations = function() {
								typeFormationService
										.fetchAllTypeFormations()
										.then(function(d) {self.typeFormations = d;
												},
												function(errResponse) {
													console.error('Error while fetching Currencies');
												});
							};

						
							self.createFormation = function() {
								FormationDService.createFormation(self.formation)
										.then(function(d) {
										self.formation = d;
										console.log('id de type a ajouter est  '
																	+ self.idSelectedType
																	+ '   a la formation '
																	+ self.formation.idFormation);
										self.addTypeToFormation(self.idSelectedType,self.formation.idFormation);
										self.fetchAllFormations;		 
												},function(errResponse) {
													console.error('Error while creating formation.');
												});
							};

							self.updateFormation = function(formation, id) {
								FormationDService.updateFormation(formation, id)
										.then(
												//self.addTypeToFormation(self.idSelectedType,self.formation.idFormation),
												self.updateTypeOfFormation(self.idOldType,self.idSelectedType,self.formation.idFormation),
												self.fetchAllFormations,
											function(errResponse) {
													console.error('Error while updating formation.');
												});
							};

							self.deleteFormation = function(id) {
								FormationDService.deleteFormation(id)
										.then(
												self.fetchAllFormations,
												function(errResponse) {
													console.error('Error while deleting formation.');
												});
							};
	                          
							self.addTypeToFormation = function(idt, idf) {
								FormationDService.addTypeToFormation(idt, idf).then(function(d) {
											self.formations=d;
									self.fetchAllFormations();
									self.reset();
										},function(errResponse) {
									 console.error('Error while adding type to fotmation.');
												});
							};
							  
							self.updateTypeOfFormation = function(idoldt,idnewt,idf) {
								FormationDService.updateTypeOfFormation(idoldt,idnewt,idf).then(function(d) {
											self.formations=d;
									self.fetchAllFormations();
									self.reset();
										},function(errResponse) {
									 console.error('Error while adding type to fotmation.');
												});
							};
							
							self.update = function() {
								console.log('updating d\'une formation'
										+ self.formation.idFormation);
								self.updateFormation(self.formation,
										self.formation.idFormation);
								self.reset();
								self.showMe=false;
							};
							
							self.add = function() {
//								if (self.formation.idFormation === null) {
									// convertion de date de string a date
									var st2 = self.formation.dateFin;
									var st1 = self.formation.dateDebut;
									console.log('old date  '+ self.formation.dateFin);
									var dateF = new Date(st2);
									var dateD = new Date(st1);
									dateF = new Date(dateF.getTime() + 86400000);
									dateD = new Date(dateD.getTime() + 86400000);
									console.log(' new date of formation '+ dateF);
									self.formation.dateFin = dateF;
									self.formation.dateDebut = dateD;

									self.createFormation(self.formation);
				
//								} else {
//									self.updateFormation(self.formation,
//											self.formation.idFormation);
//									console.log('formation updated with id ',
//											self.formation.idFormation);
//								}
								self.reset();
								self.showMe=false;
							};

							self.edit = function(id) {
								for (var i = 0; i < self.formations.length; i++) {
									if (self.formations[i].idFormation == id) {
										self.formation = angular.copy(self.formations[i]);
										self.getAlltypeFormations();
										break;
									}
								}
								self.showMe=false;
							};

							self.remove = function(id) {
								console.log('id to be deleted', id);
								self.deleteFormation(id);
								self.showMe=false;
							};

							self.show = function(id) {
								self.getOneFormation(id);
								//self.showMe = !self.showMe;
								if(self.showMe===true)
								{
								self.showMe=self.showMe;
								}
							    else{
								self.showMe=!self.sowMe;
								}
							};

							self.reset = function() {
								self.formation = {
									idFormation : null,
									nomFormation : '',
									dateDebut : '',
									dateFin : '',
									descFormation : '',
									dure : ''
								};
								//self.typeFormations = [];
								$scope.myForm.$setPristine(); // reset Form
							};
							self.fetchAllFormations();
							self.getAlltypeFormations();
						} ]);