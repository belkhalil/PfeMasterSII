'use strict';

App.
	controller('UsersController',
			['$scope','$http','$location',
			function($scope, $http ,$location) {
				//start				   
				var self = this;
				var addUserToGroupUrl = 'http://localhost:8080/group/addUserToGroup';
				var addUserUrl = 'http://localhost:8080/user/add';
				var loadGroupsUrl = 'http://localhost:8080/group/group/';
				var loadUsersUrl = 'http://localhost:8080/user/users';
				var updateUserUrl = 'http://localhost:8080/user/update/';
				var deletUserUrl = 'http://localhost:8080/user/delete/';
				var loaduserGroupsUrl ='http://localhost:8080/user/UserGroups/';
				var userByCategoryUrl='http://localhost:8080/user/usersbygroup/';
				var removeUserFromGroupUrl ='http://localhost:8080/group/removeUserFromGroup';
				
				self.viewMode = 'add';// update //
				self.idGroup = '';
				self.idUser = '';
				self.user = {
					firstName : '',
					lastName : '',
					email : '',
					password : '',
					telephone : ''
				};
				self.groups = [ {}, {} ];
				self.userGroups = [ {}, {} ];
				self.rights = [ {}, {} ];
				self.users = [];
				self.nameForSearch='';
				self.idGroupForSearch='';
				self.oldusers=[];
				self.disc='' ;
				
				self.addUser =function(){
					
					$http
					.post(addUserUrl,self.user)
					.success(
							function(data, status, headers,config) {
								self.user=data ;
								if (self.idGroup!=0) {
									self.addUserToGroup();
								}
								self.user = {
										firstName : '',
										lastName : '',
										email : '',
										password : '',
										telephone : ''
									};
								self.loadUsers();
							})
					.error(function(data, status, headers,config) {
							});
				};
				self.addUserToGroup = function() {
					$http
					.post(addUserToGroupUrl+"?iduser="+self.user.id+"&idgroup="+self.idGroup)
					.success(
							function(data, status, headers,config) {
								
								self.loadUserGroups();
								
							})
					.error(function(data, status, headers,config) {
							});
					
				};
				self.loadGroups = function() {
					$http.get(loadGroupsUrl).then(
							function(response) {
								self.groups = response.data;
								// for( var group in self.groups){
								// console.log(group);
								// }

							}, function(errResponse) {
							});
				};
				self.loadUserGroups = function() {
					$http.get(loaduserGroupsUrl+self.user.id).then(
							function(response) {
								self.userGroups = response.data;
								
							}, function(errResponse) {
							});
				};

				self.loadUsers = function() {
					$http.get(loadUsersUrl).then(
							function(response) {
								self.users = response.data;
								self.oldusers=self.users;
							}, function(errResponse) {
							});
				};
				self.updateMode = function(id) {
					self.viewMode = 'update';

					for (var i = 0; i < self.users.length; i++) {
						
						if (self.users[i].id == id) {
							self.user = angular.copy(self.users[i]);
							// console.log('ha howa
							// :'+self.user.id);
							break;
						}
						
					}
					self.loadUserGroups();

				};
				self.addMode = function(id) {
					self.viewMode = 'add';

					self.user = {
						firstName : '',
						lastName : '',
						email : '',
						password : '',
						telephone : ''
					};
				};
				self.updateAction = function() {

					$http.put(updateUserUrl + self.user.id,
							self.user).then(
							function(response) {
								self.loadUsers();
								
							}, function(errResponse) {
							});

				};
				self.deleteUser = function(id) {
					$http
							.post(deletUserUrl + id)
							.then(
									function(response) {

										self.loadUsers();

									},
									function(errResponse) {
																		
									});

				};
				//last
				self.removeUserFromGroup=function(idGroup){
					$http
					.post(removeUserFromGroupUrl+"?idUser=" +self.user.id+"&idGroup="+idGroup)
					.then(
							function(response) {
								self.loadUserGroups();
							},
							function(errResponse) {
																
							});
				};
				self.search=function(){
					var tempUsers=[];
					for (var int = 0; int <self.oldusers.length; int++) {
						var search_element = self.oldusers[int].firstName;
						if (search_element.toLowerCase().indexOf(self.nameForSearch) >= 0) {
							tempUsers.push(angular.copy(self.oldusers[int]));
						};
					}
					self.users=tempUsers;
				};
				self.updateByCategory =function(){
					if(self.idGroupForSearch!=0){
						$http
						.get(userByCategoryUrl + self.idGroupForSearch)
						.then(
								function(response) {
									self.users=response.data;
								},
								function(errResponse) {
									
								});
					}else{
						self.loadUsers();
					};
				};
				self.getUserDetail=function(id){
					
					 $location.url('userdetail/'+id);
				};
				self.loadUsers();
				self.loadGroups();
				//end
				}]);

