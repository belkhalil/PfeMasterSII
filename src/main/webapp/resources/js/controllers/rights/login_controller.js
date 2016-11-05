'use strict';
App.
	controller('LoginController',
			['$scope','$http','$location','MainModelService',
			function($scope, $http,$location,MainModelService) {//,MainModelService 'MainModelService',
				//
				var self = this;
		         self.menu=[];
		         self.user={email:'',password:''};
		         var loginUrl ='http://localhost:8080/user/login';
		         var menuUrl ='http://localhost:8080/menu/getMenu/';
		         var logoutUrl='http://localhost:8080/user/logout';
		          self.login = function(){
		        	  
		        	  $http.post(loginUrl,self.user).success(function(data, status, headers, config) {
		        		  //self.loadingMenu();
		        		  self.user=data;
		        		  MainModelService.logedUserId=self.user.id;
		        		  $location.url('/');
		        		})
		        		.error(function(data, status, headers, config) {
		        			
		        		});
		          };
		          
		          self.loadingMenu =function(){
		        	  $http.get(menuUrl).success(function(data, status, headers, config) {
		        		  self.menu =data;
		        		  for(var item in self.menu){
		        			  var obj =self.menu[item];
		        			  
		        			  for(var t in obj){
		        			  }
		        		  }
		        		})
		        		.error(function(data, status, headers, config) {
		        		});
		          };
		          self.logout =function(){
		        	  $http.post(logoutUrl).success(function(data, status, headers, config) {
		        		  self.loadingMenu();
		        		})
		        		.error(function(data, status, headers, config) {
		        		});
		          };
		          self.loadingMenu();
		          //
		      }]);