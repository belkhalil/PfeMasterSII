App.controller(
				'seanceController',
				[
						'$scope',
						'SeanceService',
						'MatiereService',
						'$http',
						'$q',
						function($scope, SeanceService, MatiereService, $http,
								$q) {
							var self = this;
							self.seance = {
								idSeance : null,
								Sommaire : '',
								Objet : ''
							};
							self.Seanceshow = {
								idSeance : null,
								Sommaire : '',
								Objet : ''
							};
							self.seances = [];
							self.matieres = [];
							$scope.showMe = false;
							self.idSelectedMatiere = null;
							self.nbrSemaines = null;
							
							var MINUTE = 60 * 1000;
							var HOUR =   MINUTE * 60;
							var DAY =    HOUR   * 24;
							var WEEK =   DAY    *  7;
							var date_obj = new Date('');

							self.getOneSeance = function(id) {
								SeanceService
										.getOneSeance(id)
										.then(
												function(d) {
													self.Seanceshow = d;
													console
															.log(self.Seanceshow);
												},
												function(errResponse) {
													console
															.error('Error while fetching Currencies');
												});
							};

							self.fetchAllMatieres = function() {
								MatiereService
										.fetchAllMatieres()
										.then(
												function(d) {
													self.matieres = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Currencies');
												});
							};

							self.fetchAllSeances = function() {
								SeanceService
										.fetchAllSeances()
										.then(
												function(d) {
													self.seances = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Currencies');
												});
							};

							self.createSeance = function() {
								SeanceService
										.createSeance(self.seance)
										.then(
												function(d) {
													self.seance = d;
													console.log(' id de seance a ajouter:'
																	+ self.seance.idSeance);

													console.log('ajouter la seance :'
																	+ self.seance.idSeance
																	+ 'au matiere'
																	+ self.idSelectedMatiere);
													self.addSeanceToMatiere(
																	self.seance.idSeance,
																	self.idSelectedMatiere);
													self.fetchAllSeances();
												},
												function(errResponse) {
													console.error('Error while creating seance.');
												});
							};

							self.updateSeance = function(seance, id) {
								SeanceService
										.updateSeance(seance, id)
										.then(
												self.fetchAllSeances,
												function(errResponse) {
													console
															.error('Error while updating seance.');
												});
							};

							self.deleteSeance = function(id) {
								SeanceService
										.deleteSeance(id)
										.then(
												self.fetchAllSeances,
												function(errResponse) {
													console
															.error('Error while deleting seance.');
												});
							};

							self.addSeanceToMatiere = function(idS, idM) {
								SeanceService
										.addSeanceToMatiere(idS, idM)
										.then(
												function(d) {
													self.fetchAllSeances();
													self.reset();
												},
												function(errResponse) {
													console
															.error('Error while adding seance to module.');
												});
							};

							self.update = function() {
								console.log('updating d\'un seance'
										+ self.seance.idSeance);
								self.updateSeance(self.seance,
										self.seance.idSeance);

								self.fetchAllSeances();
								$scope.showMe=false;
								self.reset();
							};

							self.add = function() {

								//console.log('le nombre de semaines est '+ self.nbrSemaines);

								//if (self.nbrSemaines === null) {

									// convertion de date de string a date
									var stringDate = self.seance.dateSeance;
									console.log('date old '
											+ self.seance.dateSeance);
									var dateS = new Date(stringDate);
									dateS = new Date(dateS.getTime());
									console.log(' nouvelle date ' + dateS);
									self.seance.dateSeance = dateS;
									console.log('la date de seance  '
											+ self.seance.dateSeance);
                                    //
									console.log('l\'heur de seance  '+ self.seance.heureDebut+"--------"+ typeof(self.seance.heureDebut));
									console.log('l\'heur de seance  '+ self.seance.heureFin);
									//self.seance.dateSeance.setDate(self.seance.dateSeance.getDate() + 7);
									//console.log('la date de seance apres l\'jout de semana  '+ self.seance.dateSeance);
								    self.createSeance(self.seance);
//								} else {
//									 for(var i=0 ; i < self.nbrSemaines;i++)
//									 {
//										 if(i===self.nbrSemaines)
//											 {
//											 break;
//											 }
//									 var stringDate=self.seance.dateSeance;
//									 console.log('old date '+self.seance.dateSeance);
//									 var dateS = new Date(stringDate);
//									 dateS = new Date(dateS.getTime());
//									 console.log(' nouvelle date '+dateS);
//									 self.seance.dateSeance=dateS;
//									//l'\insersion dans la base 			            
//									 self.createSeance(self.seance);
//									 //on incremente la date par 7 jours  
//									 self.seance.dateSeance.setDate(self.seance.dateSeance.getDate()+7);
//															
//									 }
//								}
								self.reset();
								$scope.showMe = false ;
							};

							
							
							self.edit = function(id) {
								for (var i = 0; i < self.seances.length; i++) {
									if (self.seances[i].idSeance == id) {
										self.seance = angular
												.copy(self.seances[i]);
										break;
									}
								}
								$scope.showMe = false ;
							};

							self.remove = function(id) {
								console.log('id to be deleted', id);
								self.deleteSeance(id);
								$scope.showMe = false ;
							};

							self.show = function(id) {
								self.getOneSeance(id);
								
									//$scope.showMe=!$scope.showMe;
									if($scope.showMe===true)
										{
										$scope.showMe=$scope.showMe;
										}
									else{
										$scope.showMe=!$scope.sowMe;
										}
										
							};

							self.reset = function() {
								self.seance = {
									idSeance : null,
									Sommaire : '',
									Objet : ''
								};
								$scope.myForm.$setPristine(); // reset Form
							};
							self.fetchAllSeances();
							self.fetchAllMatieres();
						} ]);