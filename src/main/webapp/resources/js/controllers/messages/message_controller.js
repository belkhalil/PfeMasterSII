'use strict';

App.
	controller('MessageController',
			['$scope','$http','$location',
			function($scope, $http ,$location, $window) {
				//start				   
				var self = this;
				var sendMessage = 'http://localhost:8080/message/messages';
				var messageRecus = 'http://localhost:8080/message/messageRecus';
				var messageEnvoyees = 'http://localhost:8080/message/messageEnvoyes';
				var deletMessage = 'http://localhost:8080/message/messageDeleted/';
				
				
				self.viewMode = 'add';// update //
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
				self.addMessage =function(){
					
					$http
					.post(sendMessage,self.message)
					.success(
							function(data, status, headers,config) {
								self.message = data ;
								console.log('creating message ',self.message);
								self.loadReceivedMessage();
								$location.url('messagesenvoyees/');
							})
					.error(function(data, status, headers,config) {
								console.error('no way an other error :');
							});
				};
				self.loadReceivedMessage = function() {
					$http.get(messageRecus).then(
							function(response) {
								self.messagesrec = response.data;
								// for( var group in self.groups){
								// console.log(group);
								// }

							}, function(errResponse) {
								console.log('fail to load messages');
							});
				};
				self.loadSendedMessage = function() {
					$http.get(messageEnvoyees).then(
							function(response) {
								self.messagesenv = response.data;
								
							}, function(errResponse) {
								console.log('fail to load Sended messages');
							});
				};

				self.deleteMessage = function(id) {
					$http
							.get(deletMessage + id)
							.then(
									function(response) {
										self.loadReceivedMessage();
									},
									function(errResponse) {
										console.log('fashlat fi delete allah iarza9 salama'
														+ errResponse);
									});

				};
				self.getMessageDetail=function(id){
					
					 $location.url('messagedetail/'+id);
				};
				self.loadReceivedMessage();
				//end
				}]);

