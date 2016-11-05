'use strict';


/*App.run(function($rootScope) {
    $rootScope.monUser = self.logedUser;
   
  });*/
App.
	controller('MainController',
			['$scope','$rootScope','$http','MainModelService','$location',
			function($scope,$rootScope, $http,MainModelService,$location) {
					
				var self=this;
				self.messageIn ='';
				self.messageOut='';
				self.users=MainModelService.users;
				self.chat_boxs=MainModelService.chat_boxs;
				self.chatActif=false;
				self.newchatbox ={
			       		id:0,
			       		actif :false,
			       		messages:[],
			       		messageToSend:'',
			       		nameSender:'',
			       		nameReceiver:'',
			       		idSender:null,
			       		isNew : true,
			       		idReceiver:null,
			       	};
				self.menu=[] ;
				$rootScope.logedUser={};
				//$rootScope.monUser= self.logedUser;
				var loadSessionData='http://localhost:8080/menu/get/';
				var logoutUrl='http://localhost:8080/user/logout';
				var OldMessagesUrl="http://localhost:8080/message/allmessagesfromto";
				
				self.setNewValue =function(){
					MainModelService.setMessage(self.messageIn);
				};
				
				self.refrech=function(){
					self.messageOut=MainModelService.getMessage();
				};
				
				MainModelService.receive().then(null, null, function(message) {
					self.users=message.users;
					self.getSessionData();
				    });
				self.directLoadForUsers=function(){
					$http.get("http://localhost:8080/menu/users/")
			    	.then(
			                function(response){
			                     self.users=response.data;
			                }, 
			                function(errResponse){
			                    
			                }
			    	);
				};
				self.getSessionData=function(){
					$http.get(loadSessionData)
			    	.then(
			                function(response){
			                	
			                	$rootScope.logedUser=response.data;
			                     //TODO
			                     if(response.status==204){
			                    	 $location.url('login');
			                     }
			                     MainModelService.logedUserId=$rootScope.logedUser.idUser;
			                     self.chatActif=false;
			                     var categoriesToDelete=[];
			                     
			                     for(var categoryName in $rootScope.logedUser.userMenu){
			                    	 var categoryEntries=$rootScope.logedUser.userMenu[categoryName] ;
			                    	 for(var entryTitle in categoryEntries){
			                    		 var techniname=categoryEntries[entryTitle];
			                    		  if(techniname=="#toremove"){
			                    			 // console.log("one has been found" +techniname);
			                    			  categoriesToDelete.push(categoryName);
			                    			  if(entryTitle=="discussion instantanée"){
			                    				  self.chatActif=true;
			                    			  }
			                    			  
			                    		  }
			                    	 }
			                    	 
			                     }
			                     
			                     for(var i=0;i<categoriesToDelete.length;i++){
			                    	var cat =categoriesToDelete[i];
			                    	delete $rootScope.logedUser.userMenu[cat];
			                     }
			                     
			                     
			                }, 
			                function(errResponse){
			                    
			                }
			    	);
				};
				self.directLoadForUsers();
				self.getSessionData();
				self.chatBox_popup=function(id){
					
			        var name ;
					for (var key in self.users) { 
						name =self.users[key];
					    if(key==id){
					    	break;
					    }
					}
					
					if(!self.chatbox_in_front(id)){
						console.log('chat box not in the front');
						
						self.newchatbox.actif=true;
						self.newchatbox.nameReceiver=name;
						self.newchatbox.idReceiver=id;
						self.newchatbox.idSender=$rootScope.logedUser.idUser;
						self.newchatbox.nameSender=$rootScope.logedUser.name;
						
						$http.get(OldMessagesUrl+"?idSender="+self.newchatbox.idSender+"&idReceiver="+self.newchatbox.idReceiver)
				    	.then(
				                function(response){
				                     var old_messages=response.data;
				                     //ol_messages.concat(self.chat_boxs[i].messages);
				                     self.newchatbox.messages=old_messages;//push(message)
				                     self.show_chat_box(angular.copy(self.newchatbox));
				                }, 
				                function(errResponse){
				                    
				                }
				       );
						
						
					}
					
					console.log('chat box in the front');
				};
				self.show_chat_box=function(newchatbox){
					var isdone=false;
					self.chat_boxs[0]=angular.copy(self.chat_boxs[1]);
					self.chat_boxs[1]=angular.copy(self.chat_boxs[2]) ;
					self.chat_boxs[2]=angular.copy(newchatbox);
				};
				self.chatbox_in_front=function(id){
					for(var i =0;i<3;i++){
						if(self.chat_boxs[i].actif){
							//console.log(i +"is actif id :" + id+" idrec"+ self.chat_boxs[i].idReciver);
							if(self.chat_boxs[i].idReceiver==id){
								return true ;
							}
						}
					}
					return false;
				};
				self.chatBox_hide=function(id){
					if(id==2){
						self.chat_boxs[2]=angular.copy(self.chat_boxs[1]) ;
						self.chat_boxs[1]=angular.copy(self.chat_boxs[0]) ;
						self.chat_boxs[0].actif=false;
					}
					if(id==1){
						self.chat_boxs[1]=angular.copy(self.chat_boxs[0]) ;
						self.chat_boxs[0].actif=false;
					}
					if(id==0){
						self.chat_boxs[0].actif=false;
					}
			
				};
				self.logout =function(){
		        	  $http.post(logoutUrl).success(function(data, status, headers, config) {
		        		  $location.url('login');
		        		})
		        		.error(function(data, status, headers, config) {
		        		});
		          };
		        self.allChatBoxsAreHiden=function(){
		        	return self.chat_boxs[0].actif||self.chat_boxs[1].actif||self.chat_boxs[2].actif;
		        }
		        
				}]);