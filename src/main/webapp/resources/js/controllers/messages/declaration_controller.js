'use strict';

App.
	controller('DeclarationController',
			['$scope','$http','$location',
			function($scope, $http ,$location, $window) {
				//start				   
				var self = this;
				var sendDeclaration = 'http://localhost:8080/message/declarations';
				var mesDeclaration = 'http://localhost:8080/message/declarations';
				var deletDeclaration = 'http://localhost:8080/message/declarationDeleted/';
				
				self.idDeclaration = '';
				self.declaration = {
					idDeclaration : '',
					objet : '',
					contenu : '',
					typeDeclaration : ''
				};
				self.declarationsenv = [];
				
				self.addDeclaration =function(){
					
					$http
					.post(sendDeclaration,self.declaration)
					.success(
							function(data, status, headers,config) {
								self.declaration = data ;
								console.log('creating declaration ',self.declaration);
								self.loadDeclarations();
								window.alert('Declaration envoyees');
							})
					.error(function(data, status, headers,config) {
								console.error('no way an other error :');
							});
				};
		
				self.loadDeclarations = function() {
					$http.get(mesDeclaration).then(
							function(response) {
								self.declarationsenv = response.data;
								
							}, function(errResponse) {
								console.log('fail to load Sdeclarations');
							});
				};

				self.deleteDeclaration = function(id) {
					$http
							.get(deletDeclaration + id)
							.then(
									function(response) {
										self.loadDeclarations();
									},
									function(errResponse) {
										console
												.log('fashlat fi delete allah iarza9 salama'
														+ errResponse);
									});

				};
				/*self.search=function(){
					var tempUsers=[];
					for (var int = 0; int <self.oldusers.length; int++) {
						var search_element = self.oldusers[int].firstName;
						if (search_element.toLowerCase().indexOf(self.nameForSearch) >= 0) {
							tempUsers.push(angular.copy(self.oldusers[int]));
						};
					}
					self.users=tempUsers;
				};*/
				self.getDeclarationDetail=function(id){
					 console.log('in the controller of declaration_controller we have the id :'+id);
					 $location.url('declarationdetail/'+id);
				};
				
				self.loadDeclarations();
				//end
				}]);

