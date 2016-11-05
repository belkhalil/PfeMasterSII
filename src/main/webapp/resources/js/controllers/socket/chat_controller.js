'use strict';
App.
	controller('ChatController',
			['$scope','$http','ChatService','MainModelService','$window',
			function($scope, $http,ChatService,MainModelService,$window) {
				
					var self =this ;
					self.loged_user=MainModelService.logedUserId;
					self.chat_boxs=MainModelService.chat_boxs;
					self.users=[];
					
				    //$scope.messages = [];
				    
				    $scope.max = 140;
				    
				    $scope.addMessage = function(box) {
				    	var messageToSend ={} ;
				    	messageToSend.message = box.messageToSend;
				    	messageToSend.idSender=box.idSender;
				    	messageToSend.idReceiver=box.idReceiver;
				    	
				    	messageToSend.nameReceiver=box.nameReceiver;
				    	messageToSend.nameSender=box.nameSender;
				    	
				        ChatService.send(messageToSend);
				        box.messageToSend = "";
				    };
				    
				    ChatService.receive().then(null, null, function(message) {
				     // $scope.messages.push(message);
				      var message_showing= false;
				      for(var i=0;i<3;i++){
				    	  
				    	  var test01 =self.chat_boxs[i].idSender==message.idReceiver;
				    	  var test02 =self.chat_boxs[i].idReceiver==message.idSender;
				    	  var test03 = test01&&test02;
				    	  
				    	  var test11 =self.chat_boxs[i].idSender==message.idSender;
				    	  var test12 =self.chat_boxs[i].idReceiver==message.idReceiver;
				    	  var test13 = test11&&test12;
				    	  
				    	  
				    	  
					    	 if(test03||test13){
					    	  self.chat_boxs[i].messages.push(message);
					    	  message_showing=true;
					    	 }
				    	 
				      }
				      var test21=message.idReceiver == MainModelService.logedUserId;
				     
				     
				     // var test23=(test21||test22)&&(!message_showing) ;
				      var test23 =!message_showing;
				      if(test23){
				    	  if(test21){
				    		  alert('new message from '+message.nameSender);
				    	  }
				      }
				      
				      
				    });
				   
				}]);

