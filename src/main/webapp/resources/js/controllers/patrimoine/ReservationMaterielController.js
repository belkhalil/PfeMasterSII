App.controller('ReservationMaterielController', [
		'$scope',
		'ReservationMService',
		'MaterielService',
		'$http',
		'$q',
		function($scope, ReservationMService,MaterielService, $http, $q) {
			var self = this;
			self.reservation = {
					idResMateriel : null,
				
			};
			self.myreservation = {
				idResMateriel : null,
			};
			self.materiel = {
					idMateriel : null,
			};
			self.idSelectedMateriel=null;
			self.materiels=[];
			
			self.reservations = [];
			$scope.showMe = false;
			self.etatdereservation = [];

			self.fetchAllMateriels = function() {
				MaterielService.fetchAllMateriels().then(
						function(d) {
							self.materiels = d;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};
			self.updateMateriel = function(materiel,id) {
				MaterielService.updateMateriel(materiel, id).then(self.fetchAllMateriels,
						function(errResponse) {
							console.error('Error while updating salle.');
						});
			};
			
			
			self.getOneReservationM = function(id) {
				ReservationMService.getOneReservationM(id).then(function(d) {
					self.myreservation = d;
					console.log(self.myreservation);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllReservationsM = function() {
				ReservationMService.fetchAllReservationsM().then(
						function(d) {
							self.reservations = d;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			self.createReservationM = function() {
				ReservationMService.createReservationM(self.reservation).then(
						function(d) {
							self.reservation = d;
							console.log(' id de reservation a ajouter:'
									+ self.reservation.idResMateriel);
							console.log(' id de materiel a reserver est:'
									+ self.idSelectedMateriel);
							self.addMaterielToReservation( self.idSelectedMateriel, self.reservation.idResMateriel);
							//self.addUserToReservation($scope.logedUser.idUser,self.reservation.idResMateriel)
							self.fetchAllReservationsM();
						}, function(errResponse) {
							console.error('Error while creating reservation.hena f controlleur');
						});
			};

			self.updateReservationM = function(reservation, id) {
				ReservationMService.updateReservation(reservation, id).then(self.fetchAllReservationsM,
						function(errResponse) {
							console.error('Error while updating reservation.');
						});
			};

			self.deleteReservationM = function(id) {
				ReservationMService.deleteReservationM(id).then(self.fetchAllReservationsM,
						function(errResponse) {
							console.error('Error while deleting reservation.');
						});
			};
			
			self.addMaterielToReservation= function(idM,idR){
				ReservationMService.addMaterielToReservation(idM,idR).then(
						function(d) {
							
						},
						function(errResponse) {
							console
									.error('Error while adding salle to reservation.');
						});
				
			};
			
			self.addUserToReservation= function(idU,idR){
				ReservationMService.addUserToReservation(idU,idR).then(
						function(d) {
							
						},
						function(errResponse) {
							console
									.error('Error while adding user to reservation.');
						});
				
			};

			self.update = function() {
				console.log('updating d\'un reservation' + self.reservation.idResMateriel);
				self.updateReservationM(self.reservation, self.reservation.idResMateriel);
				self.fetchAllReservationsM();
				self.reset();
			};

			self.add = function() {
				if (self.reservation.idResMateriel === null) {
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
					
					console.log('la reservation a ajouter !!!!!!!!!!!!:'+ self.reservation.idResMateriel+'et la date '+ self.reservation.heureDebut);
					
					self.createReservationM(self.reservation);
									
				} else {
					self.updateReservationM(self.reservation, self.reservation.idResMateriel);
					console.log('reservation updated with id ',
							self.reservation.idResMateriel);
				}
				self.reset();
				$scope.showMe=false;
			};

			self.edit = function(id) {
				for (var i = 0; i < self.reservations.length; i++) {
					if (self.reservations[i].idResMateriel == id) {
						self.reservation = angular.copy(self.reservations[i]);
						break;
					}
				}
				//$scope.showMe=false;
			};
			
			self.editMateriel = function(id) {
				for (var i = 0; i < self.materiels.length; i++) {
					if (self.materiels[i].idMateriel == id) {
						self.materiel = angular.copy(self.materiels[i]);
						break;
					}
				}
				//$scope.showMe=false;
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteReservationM(id);
				$scope.showMe=false;
			};
           //recuperation de id de salle 
			self.getIdMateriel = function(id){
				self.idSelectedMateriel=id;
			};
			
			//valider la reservation 
			self.valider=function(id,idMateriel){
				/*self.getOneReservationM(id);
				self.myreservation.decision="reserver";
				self.updateReservationM(self.myreservation, self.myreservation.idResMateriel);
				self.fetchAllReservationsM();*/
				
				
				self.edit(id);
				self.reservation.decision="reserver";
				self.editMateriel(idMateriel);
				self.materiel.etat=true;
				self.materiel.labelEtat="reserver";
				self.updateMateriel(self.materiel, self.materiel.idMateriel);
				self.updateReservationM(self.reservation, self.reservation.idResMateriel);
				self.fetchAllReservationsM();
				
				console.log("hada howa mol lf3la !!!!!!!!!!!!!!!!!!!!"+$scope.logedUser.name);
				
			};
			
			//annulation de la reservarion 
			self.rejeter=function(id,idMateriel){
				/*self.getOneReservationM(id);
				self.myreservation.decision="reserver";
				self.updateReservationM(self.myreservation, self.myreservation.idResMateriel);
				self.fetchAllReservationsM();*/
				self.edit(id);
				self.editMateriel(idMateriel);
				self.reservation.decision="rejeter"
					
				self.materiel.etat=false;
				self.materiel.labelEtat="disponible";
				self.updateMateriel(self.materiel, self.materiel.idMateriel)
				
				self.updateReservationM(self.reservation, self.reservation.idResMateriel);
				self.fetchAllReservationsM();
				
			};
			
			
			self.show = function(id) {
				self.getOneReservationM(id);
				
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
						idResMateriel : null,
					
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllReservationsM();
			self.fetchAllMateriels();
		} ]);