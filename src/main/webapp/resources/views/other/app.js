
'use strict';
var app=angular.module("app",['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
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
		.when('/formationContinue',{
			templateUrl:'views/formation/gestionFormationC.html',
			controller:'formationContinueController'
		})
		.when('/formationDiplomante',{
			templateUrl:'views/formation/gestionFormationD.html',
			controller:'formationDiplomanteController'
		})
		.when('/niveau',{
			templateUrl:'views/formation/gestionNiveau.html',
			controller:'niveauController'
		})
		.when('/typeFormation',{
			templateUrl:'views/formation/gestionTypeFormation.html',
			controller:'typeFormationController'
		})
		.otherwise({
			redirectTo:'/'
		});
});