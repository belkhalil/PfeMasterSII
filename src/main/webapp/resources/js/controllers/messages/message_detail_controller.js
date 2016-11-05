'use strict';
App.
	controller('MessageDetailCtrl',
			['$scope','$http','$location','$routeParams',
			function($scope, $http,$location,$routeParams) {
				
				var loadMessageUrl = 'http://localhost:8080/message/message/';
				var self =this;
				self.message={};
				
				
				self.getMessage=function(){
					var id =parseInt($routeParams.id) ;
					$http.get(loadMessageUrl+id).then(
							function(response) {
								self.message = response.data;
								
							}, function(errResponse) {
								
							});
				};
				
				self.getMessage();
		      }]);