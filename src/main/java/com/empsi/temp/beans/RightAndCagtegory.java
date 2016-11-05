package com.empsi.temp.beans;

import java.util.Hashtable;

public class RightAndCagtegory {


	
	private Hashtable<String,Hashtable<String, String>> categories;
	private Hashtable<String,String> userEntries;
	private Hashtable<String,String> messagesEntries ;
	private Hashtable<String,String> declarationEntries;
	private Hashtable<String,String> gestionInscription;
	private Hashtable<String,String> gestionClasses ;
	private Hashtable<String,String> gestionFormation;
	private Hashtable<String,String> gestionPatrimoine;
	private Hashtable<String,String> discussionInstantanee ;
	
	public Hashtable<String, Hashtable<String, String>> getCategories() {
		return categories;
	}



	public void setCategories(
			Hashtable<String, Hashtable<String, String>> categories) {
		this.categories = categories;
	}



	public Hashtable<String, String> getUserEntries() {
		return userEntries;
	}



	public void setUserEntries(Hashtable<String, String> userEntries) {
		this.userEntries = userEntries;
	}



	



	public RightAndCagtegory() {
		
		userEntries =new Hashtable<String, String>();
		userEntries.put("les groupes","#groups" );
		userEntries.put("les utilisateur","#users" );
		userEntries.put("les droirts","#rights" );
		
		
		
		gestionInscription =new Hashtable<String,String>();
		gestionInscription.put("gestion comptes", "#gestion_inscription");
		gestionInscription.put("inscrire a une formation","#inscriptionForm");
		
		
		
		categories =new Hashtable<String, Hashtable<String,String>>();
		
		gestionFormation=new Hashtable<String,String>();
		gestionFormation.put("Enseignant Permanant", "#EnsP");
		gestionFormation.put("Enseingant Vacataire", "#ensV");
		gestionFormation.put("Etudiant", "#Etudiant");
		gestionFormation.put("Formtion Continue", "#formationContinue");
		gestionFormation.put("Types de formation", "#typeFormation");
		gestionFormation.put("Formtion Diplomante", "#formationDiplomante");
		gestionFormation.put("Niveaux ", "#niveau");
		gestionFormation.put("Semestre", "#semestre");
		gestionFormation.put("Module", "#module");
		gestionFormation.put("Matieres", "#matiere");
		gestionFormation.put("Seances", "#seance");
		gestionFormation.put("affectation des matieres aox profs ", "#affectationMatieresEnsP");
		gestionFormation.put("Programme", "#consulterPrg");
		
		gestionPatrimoine=new Hashtable<String,String>();
		gestionPatrimoine.put("Salles", "#salles");
		gestionPatrimoine.put("Materiels", "#materiels");
		gestionPatrimoine.put("Consultation des salles", "#consulterSalles");
		gestionPatrimoine.put("Consultation les materiels", "#consulterMateriels");
		gestionPatrimoine.put("gestion des reservations des salles", "#gestionReservationSalle");
		gestionPatrimoine.put("gestion des reservations des materiels", "#gestionReservationMateriel");
		

		discussionInstantanee =new Hashtable<String,String>();
		discussionInstantanee.put("discussion instantanée", "#toremove");
		
		
		gestionClasses =new Hashtable<String,String>();
		gestionClasses.put("ajouter classe", "#classe");
		gestionClasses.put("ma classe", "#maClasse");
		gestionClasses.put("gestion etudiants/classes", "#gestionclasse");
		gestionClasses.put("contacter classe", "#messagesClasse");
		gestionClasses.put("message recus de ma classe","#messagesClasseRecus");
		gestionClasses.put("publier Document","#publierDocument");	
		gestionClasses.put("les documents partages", "#listFiles");
		gestionClasses.put("les documents partages", "#listFiles"); 
		
		
		messagesEntries =new Hashtable<String,String>();
		messagesEntries.put("Nouveau message" ,"#send");
		messagesEntries.put("Messages envoyees","#messagesenvoyees");
		messagesEntries.put("Messages Recus","#messages");
		
		declarationEntries=new Hashtable<String,String>();
		declarationEntries.put("gestion Declarations" ,"#gestionDeclaration");
		declarationEntries.put("declaration" ,"#declaration");
		
		categories.put("gestion des droits d'accès", userEntries);
		categories.put("Inscriptions", gestionInscription);
		categories.put("messages", messagesEntries);
		categories.put("Declaration", declarationEntries);
		categories.put("classe", gestionClasses);
		categories.put("formation", gestionFormation);
		categories.put("discussion", discussionInstantanee);
		categories.put("Patrimoine", gestionPatrimoine);

	}	

}
