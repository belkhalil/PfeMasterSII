package com.empsi.temp.beans;



import java.util.Hashtable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.empsi.entities.rights.Right;
import com.fasterxml.jackson.annotation.JsonIgnore;
@XmlRootElement
public class UserBean {
	
	private Long idUser;
	private Hashtable<String, Hashtable<String, String>> userMenu;// we can have// multimenues// with // different // names									
	private String name;
	@JsonIgnore
	private RightAndCagtegory rightAndCagtegory;

	public UserBean() {
		userMenu = new Hashtable<String, Hashtable<String, String>>();
		rightAndCagtegory = new RightAndCagtegory();
	}

	public Hashtable<String, Hashtable<String, String>> getMenu() {
		return userMenu;
	}

	public void setMenu(Hashtable<String, Hashtable<String, String>> menu) {
		this.userMenu = menu;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean hasrightTo(String right, String category) {

		if (userMenu.containsKey(category)) {
			Hashtable<String, String> rights = userMenu.get(category);
			if (rights.containsKey(right)) {
				return true;
			}
		}
		return false;
	}

	public void loadMenus(List<Right> rights) {
		// 3la assa bli les right rahom deja 7aido manhom les doublants
		//afficherAvantLoad(rights);
		Hashtable<String, Hashtable<String, String>> categoriesDictionary = rightAndCagtegory.getCategories();
		for (String category : categoriesDictionary.keySet()) {
			Hashtable<String, String> dictionaryItems = categoriesDictionary.get(category);
			for (String itemeTitle : dictionaryItems.keySet()) {
				String url = dictionaryItems.get(itemeTitle);
				//System.out.println("in dictionary we get into : [category :" +category+ "  ,key: "+ itemeTitle +" ,value: "+url+ "];");
				for (Right right : rights) {
					//System.out.println("          i will compared with :" +right.toString());
					//System.out.println("          result in category :"+ (right.getCategory().equals(category)) +
					//					" and in right name "+(right.getName().equals(itemeTitle.toString())+""));
					//System.out.println("         more rightName :"+right.getName()+": itemTitle :"+itemeTitle+":");
					if (right.getCategory().equals(category)) {
						
						if (right.getName().contains(itemeTitle)) {

							Hashtable<String, String> userCategoryItemes = userMenu
									.get(category);
							if (userCategoryItemes==null) {
								
								userCategoryItemes = new Hashtable<String, String>();
								userCategoryItemes.put(itemeTitle, url);
								userMenu.put(category, userCategoryItemes);
								
								
							} else {
								userCategoryItemes.put(itemeTitle, url);
								
							}
						}
					}
				}

			}
		}
		//afficherApresLoad(userMenu);
	}
	public  void afficherAvantLoad(List<Right> rights){
		System.out.println("**************** avant le loading **************");
		for(Right right:rights){
			System.out.println(right.toString());
		}
	}
	public void afficherApresLoad(Hashtable<String, Hashtable<String, String>> table){

		System.out.println("**************** apres le loading **************");
		for (String category: table.keySet()) {
			System.out.println("**************");
			System.out.println(category+ ":");
			Hashtable<String, String > items =table.get(category);
			for (String itemKey: items.keySet()) {
				System.out.println(itemKey+ " : "+ items.get(itemKey));
			}
			System.out.println("**************");
		}
	}
	public Hashtable<String, Hashtable<String, String>> getUserMenu() {
		return userMenu;
	}
	
}
