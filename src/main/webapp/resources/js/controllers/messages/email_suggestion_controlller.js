'use strict';

App.
	controller('EmailSuggestionController',
			['$scope','$http','$location',
			function($scope, $http ,$location) {
				//start				   
				var self = this;
				var loadUsersUrl = 'http://localhost:8080/user/users';
				
				self.users = [];
				
				self.loadUsers = function() {
					$http.get(loadUsersUrl).then(
							function(response) {
								self.users = response.data;
							}, function(errResponse) {
							});
				};
				
				self.loadUsers();
		
				//end
				}]);

