package com.empsi.controllers.rest.messages;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empsi.entities.messages.Declaration;
import com.empsi.entities.rights.User;
import com.empsi.services.messages.IDeclarationMetier;
import com.empsi.services.rights.UserService;
import com.empsi.temp.beans.UserBean;
@RestController
@RequestMapping("/message/")
public class DeclarationRestController {

	@Autowired
	private IDeclarationMetier declarationMetier;
	
	@Autowired
	private UserService userService ;
	
	@RequestMapping(value = "declarations", method = RequestMethod.POST)
	public Declaration SendDeclarationForm( @RequestBody Declaration dec , BindingResult bindingResult, HttpSession httpSession){
			dec.setDatedeclaration(new Date());
			try {
				UserBean senderBean = (UserBean) httpSession.getAttribute("userBean");
				User user =userService.findUserById(senderBean.getIdUser());
				dec.setUser(user);
				dec.setDatedeclaration(new Date());
				declarationMetier.save(dec);
				
				return dec;		
			} catch (Exception e) {
				return null;
			}	
	}
	
	@RequestMapping(value = "/declarations" , method = RequestMethod.GET)
	public List<Declaration> mesDeclaration( Model model , HttpSession httpSession ) {
		UserBean senderBean = (UserBean) httpSession.getAttribute("userBean");
		List<Declaration> declarations = declarationMetier.declarations(senderBean.getIdUser());
		model.addAttribute("declarations", declarations);
		return declarations;
	}
	
	@RequestMapping(value = "/declaration/{id}" , method = RequestMethod.GET)
	public Declaration getDeclaration( @PathVariable Long id){
		System.out.println("id  declaration=>"+declarationMetier.get(id).getIdDeclaration());
		Declaration declaration =declarationMetier.get(id);
		return declaration;
	}
	
	@RequestMapping(value = "/declarationDeleted/{id}" , method = RequestMethod.GET)
	public boolean deleteDeclaration( @PathVariable Long id){
		System.out.println("IdDec=>"+declarationMetier.get(id).getIdDeclaration());
		boolean c =  declarationMetier.delete(id);
		System.out.println("==> "+c);
		return c;
	}
	@RequestMapping(value = "/declarationRecus" , method = RequestMethod.GET)
	public List<Declaration> receivedDeclaration( Model model , HttpSession httpSession ) {
		List<Declaration> declarations = declarationMetier.getAll();
		model.addAttribute("declarations", declarations);
		return declarations;
	}
}
