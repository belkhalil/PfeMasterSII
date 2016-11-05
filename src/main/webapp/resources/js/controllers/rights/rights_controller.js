'use strict';

App.
	controller('RightsController',['$scope','$http',
			function($scope, $http) {
				//begin				   
				var self = this;
				var rightUrl= 'http://localhost:8080/right/right';
				var categoriesUrl = 'http://localhost:8080/right/categories';
				self.categories=[];
				self.category='';
				self.rights=[];
				self.name='';
				self.disc='' ;
				self.right={};
				
				self.deleteRight=function(id){
					$http.delete(rightUrl+"/"+id)
					.then(
							function(response){
								self.loadWhatIneed();
								return response.data;
								
							}, 
							function(errResponse){
								
							}
					);
					
				};
				
				
				self.add = function(){
					self.right.name=self.name;
					self.right.disc=self.disc;
					self.right.category=self.category;
					$http.post(rightUrl,self.right).success(
							function(data, status, headers,config) {
								
								self.loadWhatIneed();
								
							})
					.error(function(data, status, headers,config) {
								
							});
				};
				
				self.loadWhatIneed= function(){
				//
				$http.get(rightUrl).then(function(response){
						
						self.rights=response.data ;
		
					},
					function(errResponse){
						
					});
				//
				$http.get(categoriesUrl).then(function(response){
					 	self.categories=response.data ;
				},
				function(errResponse){
					
				});
				//
				};
				//
				
				self.loadWhatIneed();
				//end
				}]);

