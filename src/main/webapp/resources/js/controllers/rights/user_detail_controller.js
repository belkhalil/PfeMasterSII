'use strict';

App.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

App.
	controller('UserDetailCtrl',
			['$scope','$http','$location','$routeParams','$window',
			function($scope, $http,$location,$routeParams,$window) {
				
				var loadUserUrl = 'http://localhost:8080/user/user/';
				var updateUserUrl = 'http://localhost:8080/user/update/';
				var uploadUrl = "http://localhost:8080/files/upload";
				var self =this;
				self.user={};
				self.file=null;
				self.imageLink="";
				
				self.getUser=function(){
					var id =parseInt($routeParams.id) ;
					$http.get(loadUserUrl+id).then(
							function(response) {
								self.user = response.data;
								self.imageLink="img/archive/"+self.user.email+".png"+'?decache=' + Math.random();;
							}, function(errResponse) {
								
							});
				};
				
				self.onSubmit=function(){
					console.log("submit" + self.user);
					self.update();
				};
				
				//TODO
				self.update= function() {
					if(self.file!=null){
						self.uploadFile();
					}else{
						self.updateUser();
					}
				};
				self.uploadFile = function(){
					var fd = new FormData();
			        fd.append('file', self.file);
			        $http.post(uploadUrl+"?name="+self.user.email, fd, {
			            transformRequest: angular.identity,
			            headers: {'Content-Type': undefined}
			        })
			        .then(
						function(response) {
							
							self.user.email=response.data.name;
							self.user.email =null;
							self.user.email=response.data.name;
//							console.log(self.user.imageLink);
							self.updateUser();
						}, function(errResponse) {
						});
			    };
			    
			    self.updateUser =function(){
			    	$http.put(updateUserUrl + self.user.id,
							self.user).then(
							function(response2) {
								self.getUser();
								alert("update done");
							}, function(errResponse2) {
							});
			    };
				//TODO
				self.getUser();
				
		      }])	;