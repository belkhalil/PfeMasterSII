App.controller('ReservationSalleController', [
		'$scope',
		'ReservationService',
		'SalleService',
		'$http',
		'$q',
		function($scope, ReservationService,SalleService, $http, $q) {
			var self = this;
			self.reservation = {
				idResSalle : null,
				
			};
			self.myreservation = {
				idResSalle : null,
			};
			self.salle = {
					idSalle : null,
			};
			self.idSelectedSalle=null;
			self.salles=[];
			
			self.reservations = [];
			$scope.showMe = false;
			self.etatdereservation = [],

			self.fetchAllSalles = function() {
				SalleService.fetchAllSalles().then(
						function(d) {
							self.salles = d;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};
			self.updateSalles = function(salle,id) {
				SalleService.updateSalle(salle, id).then(self.fetchAllSalles,
						function(errResponse) {
							console.error('Error while updating salle.');
						});
			};
			
			
			self.getOneReservation = function(id) {
				ReservationService.getOneReservation(id).then(function(d) {
					self.myreservation = d;
					console.log(self.myreservation);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllReservations = function() {
				ReservationService.fetchAllReservations().then(
						function(d) {
							self.reservations = d;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			self.createReservation = function() {
				ReservationService.createReservation(self.reservation).then(
						function(d) {
							self.reservation = d;
							console.log(' id de reservation a ajouter:'
									+ self.reservation.idResSalle);
							console.log(' id de la salle a reserver est:'
									+ self.idSelectedSalle);
							self.addSalleToReservation( self.idSelectedSalle, self.reservation.idResSalle);
							self.addUserToReservation($scope.logedUser.idUser,self.reservation.idResSalle)
							self.fetchAllReservations();
						}, function(errResponse) {
							console.error('Error while creating reservation.');
						});
			};

			self.updateReservation = function(reservation, id) {
				ReservationService.updateReservation(reservation, id).then(self.fetchAllReservations,
						function(errResponse) {
							console.error('Error while updating reservation.');
						});
			};

			self.deleteReservation = function(id) {
				ReservationService.deleteReservation(id).then(self.fetchAllReservations,
						function(errResponse) {
							console.error('Error while deleting reservation.');
						});
			};
			
			self.addSalleToReservation= function(idS,idR){
				ReservationService.addSalleToReservation(idS,idR).then(
						function(d) {
							
						},
						function(errResponse) {
							console
									.error('Error while adding salle to reservation.');
						});
				
			};
			
			self.addUserToReservation= function(idU,idR){
				ReservationService.addUserToReservation(idU,idR).then(
						function(d) {
							
						},
						function(errResponse) {
							console
									.error('Error while adding user to reservation.');
						});
				
			};

			self.update = function() {
				console.log('updating d\'un reservation' + self.reservation.idResSalle);
				self.updateReservation(self.reservation, self.reservation.idResSalle);
				self.fetchAllReservations();
				self.reset();
			};

			self.add = function() {
				if (self.reservation.idResSalle === null) {
					// convertion de la date de string a date
					var st2 = self.reservation.finRes;
					var st1 = self.reservation.debutRes;
					

					
					console.log('old date  '+ self.reservation.finRes);
					
					var dateF = new Date(st2);
					var dateD = new Date(st1);

							
					dateF = new Date(dateF.getTime() + 86400000);
					dateD = new Date(dateD.getTime() + 86400000);

					console.log(' new date of reservation '+ dateF);
					self.reservation.finRes = dateF;
					self.reservation.debutRes = dateD;
	
					
					self.reservation.dateRes = new Date();
					self.reservation.decision="en attente";
					self.createReservation(self.reservation);
					
										
				} else {
					self.updateReservation(self.reservation, self.reservation.idResSalle);
					console.log('reservation updated with id ',
							self.reservation.idResSalle);
				}
				self.reset();
				$scope.showMe=false;
			};

			self.edit = function(id) {
				for (var i = 0; i < self.reservations.length; i++) {
					if (self.reservations[i].idResSalle == id) {
						self.reservation = angular.copy(self.reservations[i]);
						break;
					}
				}
				//$scope.showMe=false;
			};
			
			self.editSalle = function(id) {
				for (var i = 0; i < self.salles.length; i++) {
					if (self.salles[i].idSalle == id) {
						self.salle = angular.copy(self.salles[i]);
						break;
					}
				}
				//$scope.showMe=false;
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteReservation(id);
				$scope.showMe=false;
			};
           //recuperation de id de salle 
			self.getIdSalle = function(id){
				self.idSelectedSalle=id;
			};
			
			//valider la reservation 
			self.valider=function(id,idsalle){
				
				
				
				self.edit(id);
				self.reservation.decision="reserver";
				self.editSalle(idsalle);
				self.salle.etatSalle=true;
				self.salle.labelEtat="reserver";
				self.updateSalles(self.salle, self.salle.idSalle)
				self.updateReservation(self.reservation, self.reservation.idResSalle);
				self.fetchAllReservations();
				self.fetchAllSalles();
				
			};
			
			//annulation de la reservarion 
			self.rejeter=function(id,idsalle){

				self.edit(id);
				self.editSalle(idsalle);
				self.reservation.decision="rejeter"
					
				self.salle.etatSalle=false;
				self.salle.labelEtat="libre";
				self.updateSalles(self.salle, self.salle.idSalle)
				
				self.updateReservation(self.reservation, self.reservation.idResSalle);
				self.fetchAllReservations();
				
			};
			
			
			self.show = function(id) {
				self.getOneReservation(id);
				
				if($scope.showMe===true)
				{
				$scope.showMe=$scope.showMe;
				}
			    else{
				$scope.showMe=!$scope.sowMe;
				}
			};

			self.reset = function() {
				self.reservation = {
					idResSalle : null,
					numreservation : null,
					typereservation : '',
					descreservation : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllReservations();
			self.fetchAllSalles();
		} ]);