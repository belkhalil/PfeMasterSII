'use strict';
App.
	controller('DeclarationDetailCtrl',
			['$scope','$http','$location','$routeParams',
			function($scope, $http,$location,$routeParams) {
				
				var declarationRecus = 'http://localhost:8080/message/declarationRecus/';
				var loadDec = 'http://localhost:8080/message/declaration/';

				var self =this;
				self.declarationsrecus = [];
				self.declaration={};
				//loding Deeclaration
				$scope.idd = $routeParams.id;
				
				self.getMessage=function(id){
					//var id =parseInt($routeParams.id) ;
					$http.get(loadDec+id).then(
							function(response) {
								self.declaration = response.data;
								$scope.idd = declaration.idDeclaration;
							}, function(errResponse) {
								console.log('fail to load Declaration',self.declaration);
							});
				};
				
				self.getMessage($scope.idd);
				
				
				// les declarations recus
				self.loadDeclarationsReceived = function() {
					$http.get(declarationRecus).then(
							function(response) {
								self.declarationsrecus = response.data;
								
							}, function(errResponse) {
								console.log('fail to load Sdeclarations');
							});
				};
				self.loadDeclarationsReceived();
				
		      }]);