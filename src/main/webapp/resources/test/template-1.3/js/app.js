var app = angular.module('minmax', [ 'jcs-autoValidate' ]);

app.run([
    'defaultErrorMessageResolver',
    function (defaultErrorMessageResolver) {
        // passing a culture into getErrorMessages('fr-fr') will get the culture specific messages
        // otherwise the current default culture is returned.
        defaultErrorMessageResolver.getErrorMessages().then(function (errorMessages) {
          errorMessages['reqName'] = 'entrez votre Nom svp';
          errorMessages['reqPrenom'] = 'entrez votre Prenom svp';
          errorMessages['reqEmail'] = 'entrez votre Email svp';
          errorMessages['reqCin'] = 'entrez votre CIN svp';
          errorMessages['reqGsm'] = 'entrez votre CNE svp';
          errorMessages['reqCne'] = 'entrez votre CNE svp';
          errorMessages['reqAdresse'] = 'entrez votre Adresse svp';
          errorMessages['reqDn'] = 'entrez votre date de naissance svp';
          errorMessages['nValideDate'] = 'entrez une date valide';
        });
      }
      ]);

app.controller('MinMaxCtrl', [
  '$scope',
  '$http',
  function($scope, $http) {
    $scope.formModel = {};
    $scope.onSubmit = function() {

        console.log("form submitted");
        console.log($scope.formModel);

    };
  }
]);
