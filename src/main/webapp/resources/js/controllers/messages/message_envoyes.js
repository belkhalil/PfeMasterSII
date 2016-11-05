'use strict';

App.
	controller('MessageEnvController',
			['$scope','$http','$location',
			function($scope, $http ,$location) {
				//start				   
				var self = this;
				var sendMessage = 'http://localhost:808/message/messages';
				var messageRecus = 'http://localhost:8080/message/messageRecus';
				var messageEnvoyees = 'http://localhost:8080/message/messageEnvoyes';
				var deletMessage = 'http://localhost:8080/message/messageDeleted/';
				
				self.idMessage = '';
				self.message = {
					id : '',
					objet : '',
					message : '',
					email : '',
					email_sender : ''
				};
				self.messagesrec = [];
				self.messagesenv = [];
				
				self.loadSendedMessage = function() {
					$http.get(messageEnvoyees).then(
							function(response) {
								self.messagesenv = response.data;
								console.log('msg Envoyees',self.messagesenv);
								
							}, function(errResponse) {
								console.log('fail to load Sended messages');
							});
				};

				self.deleteMessage = function(id) {
					$http
							.get(deletMessage + id)
							.then(
									function(response) {
										self.loadSendedMessage();
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
				self.getMessageDetail=function(id){
					
					 $location.url('messagedetail/'+id);
				};
				self.loadSendedMessage();
				//end
				}]);