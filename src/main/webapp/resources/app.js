'use strict';
//create the module and name it App
var App = angular.module('myApp',['ngRoute','jcs-autoValidate']);
App.config(function($routeProvider){
	$routeProvider
		.when('/',{
			templateUrl:'views/rights/main.html',
			controller:'MainController'
		}).when('/users',{
			templateUrl:'views/rights/users.html',
			controller:'UsersController'
		}).when('/groups',{
			templateUrl:'views/rights/groups.html',
			controller:'GroupsController'
		}).when('/rights',{
			templateUrl:'views/rights/rights.html',
			controller:'RightsController'
		}).when('/login',{
			templateUrl:'views/rights/login.html',
			controller:'LoginController'
		}).when('/userdetail/:id',{
			templateUrl:'views/rights/userdetail.html',
			controller:'UserDetailCtrl'
		})
		//messages
		.when('/messages',{
			templateUrl:'views/messages/messages.html',
			controller:'MessageController'
		})
		.when('/messagesenvoyees',{
			templateUrl:'views/messages/messagesEnvoyees.html',
			controller:'MessageEnvController'
		})
		.when('/send',{
			templateUrl:'views/messages/sendmessage.html',
			controller:'MessageController'
		})
		.when('/messagedetail/:id',{
			templateUrl:'views/messages/messageDetail.html',
			controller:'MessageDetailCtrl'
		})
		//declaration
		.when('/declaration',{
			templateUrl:'views/messages/declaration.html',
			controller:'DeclarationController'
		})
		.when('/declarationdetail/:id',{
			templateUrl:'views/messages/declarationDetail.html',
			controller:'DeclarationDetailCtrl'
		})
		.when('/gestionDeclaration',{
			templateUrl:'views/messages/gestionDeclaration.html',
			controller:'DeclarationDetailCtrl'
		})
		.when('/detailDec/:id',{
			templateUrl:'views/messages/detailDec.html',
			controller:'DeclarationDetailCtrl'
		})
		//formation		
		.when('/EnsP',{
			templateUrl:'views/formation/gestionEnsP.html',
			controller:'EnsPController'
		})
		.when('/ensV',{
			templateUrl:'views/formation/gestionEnsV.html',
			controller:'ensvController'
		})
		.when('/Etudiant',{
			templateUrl:'views/formation/gestionEtudiant.html',
			controller:'EtudiantController'
		})
	    .when('/formationContinue', {
			templateUrl : 'views/formation/gestionFormationC.html',
			controller : 'formationContinueController'
		}).when('/formationDiplomante', {
			templateUrl : 'views/formation/gestionFormationD.html',
			controller : 'formationDiplomanteController'
		}).when('/niveau', {
			templateUrl : 'views/formation/gestionNiveau.html',
			controller : 'niveauController'
		}).when('/typeFormation', {
			templateUrl : 'views/formation/gestionTypeFormation.html',
			controller : 'typeFormationController'
		}).when('/module', {
			templateUrl : 'views/formation/gestionModule.html',
			controller : 'ModuleController'
		}).when('/semestre', {
			templateUrl : 'views/formation/gestionSemestre.html',
			controller : 'SemestreController'
		}).when('/matiere', {
			templateUrl : 'views/formation/gestionMatiere.html',
			controller : 'MatiereController'
		}).when('/seance', {
			templateUrl : 'views/formation/gestionSeance.html',
			controller : 'seanceController'
		}).when('/affectationMatieresEnsP', {
			templateUrl : 'views/formation/affectationMatieresEnsP.html',
			controller : 'affectationMatieresEnsPController'
		}).when('/consulterPrg', {
			templateUrl : 'views/formation/ConsulterProgramme.html',
			controller : 'formationDiplomanteController'
		})

		// patrimoine
		.when('/salles', {
			templateUrl : 'views/patrimoine/gestionSalle.html',
			controller : 'SalleController'
		})
		.when('/consulterSalles', {
			templateUrl : 'views/patrimoine/ConsulterSalle.html',
			controller : 'ReservationSalleController'
		}).when('/gestionReservationSalle', {
			templateUrl : 'views/patrimoine/gestionReservationSalle.html',
			controller : 'ReservationSalleController'
		})
		.when('/materiels', {
			templateUrl : 'views/patrimoine/gestionMateriel.html',
			controller : 'MaterielController'
		}).when('/consulterMateriels', {
			templateUrl : 'views/patrimoine/ConsulterMateriel.html',
			controller : 'ReservationMaterielController'
		}).when('/gestionReservationMateriel', {
			templateUrl : 'views/patrimoine/gestionReservationMateriel.html',
			controller : 'ReservationMaterielController'
		})
		
		//les classes
		.when('/mesMessagesClasse',{
			templateUrl:'views/classe/messagesClasse.html',
			controller:'ClasseController'
		})
		.when('/messagesClasse',{
			templateUrl:'views/classe/messagesClasse.html',
			controller:'MessageClasseController'
		})
		// new class
		.when('/classe',{
			templateUrl:'views/classe/classes.html',
			controller:'ClasseController'
		})	
		.when('/gestionclasse',{
			templateUrl:'views/classe/gestion_classes.html',
			controller:'ClasseController'
		})
		.when('/maClasse',{
			templateUrl:'views/classe/maClasse.html',
			controller:'MaClasseController'
		})
		.when('/messagesClasseRecus',{
			templateUrl:'views/classe/messagesMaClasse.html',
			controller:'MessageClasseController' 
		})
		.when('/messagesClasse',{
			templateUrl:'views/classe/messagesClasse.html',
			controller:'MessageClasseController'
		})
		.when('/detailMess/:id',{
			templateUrl:'views/classe/detailmessage.html',
			controller:'MessageClasseControllerDetail'
		})
		.when('/publierDocument',{
			templateUrl:'views/classe/upload.html',
			controller:'FichierClasseController'
		})
		.when('/listFiles',{
			templateUrl:'views/classe/listFiles.html',
			controller:'FichierClasseController'
		})
		//mot de passe oubliee
		.when('/motPasse',{
			templateUrl:'views/rights/motdepasseOub.html',
			controller:'motPasseController'
		})
		//inscription formation
		.when('/inscriptionForm',{
			templateUrl:'views/inscriptionFormation/inscriptionFormation.html',
			controller:'InscriptionFormationController'
		})
		//inscription
		.when('/gestion_inscription',{
			templateUrl:'views/inscription/gestion_inscription.html',
			controller:'gestionController'
		})
		.when('/inscription_secces',{
			templateUrl:'views/inscription/inscription_secces.html',
			controller:null
		})
		.when('/inscription',{
			templateUrl:'views/inscription/inscription.html',
			controller:'inscription'
		})
		// end of new class
		.when('/error',{
			templateUrl:'views/rights/error.html'
		}).otherwise({
			redirectTo:'/'
		});
});
App.run([
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
            // type formation 
          	 errorMessages['reqType'] = 'entrez une type svp!!';
          	 //formation diplomante
               errorMessages['reqNomFormationD'] = 'entrez la valeur de ce champ svp';
             });
           }
           ]);

