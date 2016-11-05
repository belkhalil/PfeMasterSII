'use strict';
App.
	controller('MessageClasseControllerDetail',
			['$scope','$http','$location','$routeParams',
			function($scope, $http,$location,$routeParams) {
				
				var loadMessage = 'http://localhost:8080/classes/loadMessageClasse/';
				var self =this;
				self.message={};
				$scope.idd = $routeParams.id;
				
				self.getMessage=function(id){
					//var id =parseInt($routeParams.id) ;
					$http.get(loadMessage+id).then(
							function(response) {
								self.message = response.data;
								$scope.idd = message.id;
							}, function(errResponse) {
								console.log('fail to load Messages',self.message);
							});
				};
				
				self.getMessage($scope.idd);
		      }]);