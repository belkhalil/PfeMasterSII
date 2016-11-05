'use strict';

App.
	controller('GroupsController',
			['$scope','$http',
			function($scope, $http) {
				  //begin of groups
				  var self = this;
		          var grouprightsUrl='http://localhost:8080/group/grouprights';
		         // var rightClassedUrl='http://localhost:8080/angularspringv01/spring/right/rightclassed'; 
		          var addRightToGroupUrl='http://localhost:8080/group/addRightToGroup';
		          var groupUrl='http://localhost:8080/group/group/'
		          var rightUrl= 'http://localhost:8080/right/right';
		          var removeRightFromGroupUrl ='http://localhost:8080/group/removeRightFromGroup';
		          
		          self.group={id:null,groupName:'',deletable:''};
		          self.groups=[];
		          self.grouprights=[];
		          self.allrights=[];
		        //  self.allrightsClassed={};
		          self.selectedRight='';
		          self.selectedCategroy='';
		          self.viewMode='add';
		          
		          
		          self.fetchAllGroups = function(){
		        	  $http.get(groupUrl)
						.then(
								function(response){
									self.groups=response.data;
								}, 
								function(errResponse){
								}
						);
		          };
		           
		          self.createGroup = function(){
		        	  $http.post(groupUrl,self.group)
						.then(
								function(response){
									self.fetchAllGroups();
								}, 
								function(errResponse){
									
								}
						);
		          };

		         self.updateGroup = function(){
		        	 $http.put(groupUrl+self.group.id, self.group)
						.then(
								function(response){
									self.fetchAllGroups();
								}, 
								function(errResponse){
									
								}
						);
		          };
		          //waw
		         self.getGroupRights=function(){

		        	 $http.get(grouprightsUrl+"?id="+self.group.id)
						.then(
								function(response){
									 self.grouprights=response.data;
								}, 
								function(errResponse){
									
								}
						);
		        	 
		        	
		         };
		         self.addRightToGroup =function(){
		        	 
		        	 $http.post(addRightToGroupUrl+"?idgroup="+self.group.id+"&idright="+self.selectedRight).then(function(response){		
							self.grouprights=response.data ;
							self.getGroupRights();
						},
						function(errResponse){
							
						});
		        	 
		        	 
		         };
		         self.getAllRights=function(){
		        	 
						$http.get(rightUrl).then(function(response){		
							self.allrights=response.data ;
						},
						function(errResponse){
							
						});

		         };
//		         self.getAllRightsClassed=function(){
//		        	 
//						$http.get(rightClassedUrl).then(function(response){		
//							self.allrightsClassed=response.data ;
//						},
//						function(errResponse){
//							
//						});
//
//		        };
		         self.deleteGroup = function(id){
		        	 $http.delete(groupUrl+id)
						.then(
								function(response){
									self.fetchAllGroups();
								}, 
								function(errResponse){
									
								}
						);
		          };

		          self.fetchAllGroups(); 

		          
		              
		          self.edit = function(id){
		              self.viewMode='update';
		              for(var i = 0; i < self.groups.length; i++){
		                  if(self.groups[i].id == id) {
		                     self.group = angular.copy(self.groups[i]);
		                     self.getGroupRights();
		                     break;
		                  };
		              };
		          };
		              
		          self.remove = function(id){
		              if(self.group.id === id) {
		                 self.reset();
		              }
		              self.deleteGroup(id);
		          };

		          
		          self.reset = function(){
		        	  self.group={id:null,groupName:'',deletable:''};
		              $scope.myForm.$setPristine(); //reset Form
		          };
		          
		          
		          self.removeRightFromGroup=function(idRight){
						$http
						.post(removeRightFromGroupUrl+"?idRight="+idRight+"&idGroup="+self.group.id)
						.then(
								function(response) {
									self.getGroupRights();
								},
								function(errResponse) {
																	
								});
					};
		          
		          self.getAllRights();
		         // self.getAllRightsClassed();
				
				
				
					//end of groups
				}]);

