'use strict';
App.
	controller('LoginController',
			['$scope','$http','$window',
			function($scope, $http,$window) {//,MainModelService 'MainModelService',
				//
				var self = this;
		         self.menu=[];
		         self.user={email:'',password:''};
		         var loginUrl ='http://localhost:8080/user/login';
		         self.login = function(){
		        	  
		        	  $http.post(loginUrl,self.user).success(function(data, status, headers, config) {
		        		  //self.loadingMenu();
		        		  self.user=data;
		        		  $window.location.href = 'http://localhost:8080/resources/index.html#/';
		        		})
		        		.error(function(data, status, headers, config) {
		        			
		        		});
		          };
		         self.loadAdmin=function(){
		        	 self.user ={email:'admin@email.com',password:'admin'};
		         };
		         self.loadParent=function(){
		        	 
		        	 self.user ={email:'parent@email.com',password:'parent'}; 
		         };
		         self.loadEnseignant=function(){
		        	 self.user ={email:'enseignantP@email.com',password:'enseignantP'}; 
		         };
		         self.loadEtudiant=function(){
		        	 self.user ={email:'etudiant@email.com',password:'etudiant'}; 
		         };
		          //
		      }]);