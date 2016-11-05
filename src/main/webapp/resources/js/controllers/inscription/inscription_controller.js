App.directive('equalsTo', [function () {
	
    /*
    * <input type="password" ng-model="Password" />
    * <input type="password" ng-model="ConfirmPassword" equals-to="Password" />
    */
    return {
        restrict: 'A', // S'utilise uniquement en tant qu'attribut
        scope: true,
        require: 'ngModel',
        link: function (scope, elem, attrs, control) {
            var check = function () {
            //Valeur du champs courant 
            var v1 = scope.$eval(attrs.ngModel); // attrs.ngModel = "ConfirmPassword"
            //valeur du champ à comparer
            var v2 = scope.$eval(attrs.equalsTo).$viewValue; // attrs.equalsTo = "Password"
            return v1 == v2;
        };
        scope.$watch(check, function (isValid) {
            // Défini si le champ est valide
            control.$setValidity("equalsTo", isValid);
        });
    }
};
}]);


App.controller("inscription", function($scope,$http,$location,$window) {
	
		$scope.etudiant={};
		$scope.errors=null;
		$scope.exeption={message:null};
		
	
	$scope.inscritMembre=function(){
		   console.log('inscription', $scope.etudiant); 
		 $http.post("http://localhost:8080/etudiant",$scope.etudiant)

		 .success(function(data,status,headers){
		   if(!data.errors){
			   
			   $scope.etudiant=data;
			   console.log('inscription', $scope.etudiant); 
			   $scope.errors=null;
			   //alert( "nous avons envoyé un mail de confirmation a votre boite mail!" );
			   $location.url('inscription_secces/');
		   }
		   else{
			   $scope.errors=data;
			   //

		   }
		 })	
		.error(function(data,status,headers){
			$scope.exeption.message=data.message;
		});
				           
      };
});
	