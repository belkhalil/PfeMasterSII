

'use strict';
App.controller('typeFormationController', [
		'$scope',
		'typeFormationService',
		function($scope, typeFormationService) {
			var self = this;
			self.typeFormation = {
				idTypeFormation : null,
				labelTypeFormation:'',
			};
			
			
			self.typeFormations = [];
					
			

//		   self.getOneTypeFormation = function(id) {
//				typeFormationService.getOneTypeFormation(id).then(function(d) {
//					self.typeFormationshow = d;
//					console.log(self.typeFormationshow);
//				}, function(errResponse) {
//					console.error('Error while fetching Currencies');
//				});
//			};

			self.fetchAllTypeFormations = function() {
				typeFormationService.fetchAllTypeFormations().then(function(d) {
					self.typeFormations = d;

				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createTypeFormation = function() {
				typeFormationService.createTypeFormation(self.typeFormation)
				.then(self.fetchAllTypeFormations,function(errResponse) {
							console.error('Error while creating TypeFormation.');
						});
			};

			self.updateTypeFormation = function(typeFormation, id) {
				typeFormationService.updateTypeFormation(typeFormation, id)
				.then(self.fetchAllTypeFormations,function(errResponse) {
							console.error('Error while updating TypeFormation.');
						});
			};

			self.deleteTypeFormation = function(id) {
				typeFormationService.deleteTypeFormation(id)
				.then(self.fetchAllTypeFormations,function(errResponse) {
							console.error('Error while deleting TypeFormation.');
						});
			};

			

			self.update = function() {
				console.log('updating d\'un TypeFormation' + self.typeFormation.idTypeFormation);
				self.updateTypeFormation(self.typeFormation, self.typeFormation.idTypeFormation);
				self.fetchAllTypeFormations();
				self.reset();
			};
			
			self.add = function() {
				console.log('le type a ajouter::::::::'+self.typeFormation.idTypeFormation)
				self.createTypeFormation(self.typeFormation);
				self.fetchAllTypeFormations();
				self.reset();
			};

			self.edit = function(id) {
				for (var i = 0; i < self.typeFormations.length; i++) {
					if (self.typeFormations[i].idTypeFormation == id) {
						self.typeFormation = angular.copy(self.typeFormations[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteTypeFormation(id);
			};

			self.reset = function() {
				self.typeFormation = {
						idTypeFormation : null,
						labelTypeFormation : '',
					};
				
				$scope.myForm.$setPristine(); // reset Form
			};
			
			self.fetchAllTypeFormations();
		} ]);