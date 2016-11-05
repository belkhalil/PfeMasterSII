package com.empsi.controllers.rest.rights;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.empsi.entities.formation.EnsPermanent;
import com.empsi.entities.formation.EnsVacataire;
import com.empsi.entities.rights.Group;
import com.empsi.entities.rights.Right;
import com.empsi.entities.rights.User;
import com.empsi.entities.users.Etudiant;
import com.empsi.services.formation.IEnsPernamentMetier;
import com.empsi.services.formation.IEnsVacataireMetier;
import com.empsi.services.formation.IEtudiantMetier;
import com.empsi.services.rights.GroupService;
import com.empsi.services.rights.UserService;
import com.empsi.temp.beans.ConnectionModel;
import com.empsi.temp.beans.UserBean;

@Controller
@RequestMapping(value="/user")
public class UserRestController {

	@Autowired
	private ConnectionModel connectionModel;
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private IEnsPernamentMetier ensPernamentMetier;
	
	@Autowired
	private IEtudiantMetier etudiantMetier;
	
	@Autowired
	private IEnsVacataireMetier ensVacataireMetier;
	
	
	@Autowired
	private GroupService  groupService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> doLoginAction(@RequestBody User user, HttpSession httpSession) {
		Long id = userService.loginUser(user.getEmail(), user.getPassword());
		if (id != null) {
			UserBean userBean = new UserBean();
			List<Right> rights = userService.getUserAllRights(id);
			userBean.setIdUser(id);
			userBean.loadMenus(rights);
			userBean.setName(user.getEmail());
			httpSession.setAttribute("userBean", userBean);
			connectionModel.login(id, userBean.getName());
			user.setId(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		
	
		} else {
			System.out.println("login failed");
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	
	}
	@RequestMapping(value="/user/{id}",method= RequestMethod.GET,produces = "application/json")
	public ResponseEntity<User> findUserById(@PathVariable Long id){
			
			System.out.println("this the id that caused all my problemes"+id);
			User user= userService.findUserById(id);
//			if (user==null) {
//				return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//			}
			return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		//String password =CryptingTool.sha256(user.getPassword());
		//user.setPassword(password);
		userService.createUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> deleteUser( @PathVariable(value = "id") Long id) {
		
		User user =userService.findUserById(id);
		if (user == null) {
			
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deletUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		
		boolean test =false ;
		if(etudiantMetier.get(id)!=null){
			test=true ;
			Etudiant etudiant =etudiantMetier.get(id);
			etudiant.setFirstName(user.getFirstName());
			etudiant.setLastName(user.getLastName());
			etudiant.setEmail(user.getEmail());
			etudiant.setPassword(user.getPassword());
			etudiant.setTelephone(user.getTelephone());
			etudiantMetier.Update(etudiant);
		}
		if(ensPernamentMetier.get(id)!=null){
			test =true;
			EnsPermanent ensPermanent =ensPernamentMetier.get(id);
			ensPermanent.setFirstName(user.getFirstName());
			ensPermanent.setLastName(user.getLastName());
			ensPermanent.setEmail(user.getEmail());
			ensPermanent.setPassword(user.getPassword());
			ensPermanent.setTelephone(user.getTelephone());
			ensPernamentMetier.update(ensPermanent);
		}
		
		if(ensVacataireMetier.get(id)!=null)
		{
			test =true;
			EnsVacataire ensVacataire =ensVacataireMetier.get(id);
			ensVacataire.setFirstName(user.getFirstName());
			ensVacataire.setLastName(user.getLastName());
			ensVacataire.setEmail(user.getEmail());
			ensVacataire.setPassword(user.getPassword());
			ensVacataire.setTelephone(user.getTelephone());
			ensVacataireMetier.update(ensVacataire);
		}
		if(!test){
			userService.updateUser(id,user);
		}
		
		return new ResponseEntity<User>( HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			// You may decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	@RequestMapping(value = "/UserGroups/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Group>>  findUserGroups(@PathVariable Long id){
		List<Group> groups =  userService.getAllUserGroups(id);
		if (groups==null) {
			return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Group>>(groups,HttpStatus.OK);
	}
	@RequestMapping(value="/usersbygroup/{id}",method= RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<User>> findUserByGroup(@PathVariable Long id){
			
			List<User> users= userService.findUsersByGroup(id);
			if (users==null) {
				return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ResponseEntity<User> doNewAccountAction(@RequestBody User user) {
		
		//Long idUser = userService.addUser(user);
		userService.createUser(user);
		groupService.addUserToGroup(user.getId(), 1L);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<User> Logout(HttpSession httpSession) {
		UserBean userBean = (UserBean) httpSession.getAttribute("userBean");
		if(userBean!=null)
		connectionModel.logout(userBean.getIdUser());
		httpSession.setAttribute("userBean", null);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	

	@RequestMapping(value = "/getmotPasse", method = RequestMethod.POST)
	public ResponseEntity<User> getCompte(@RequestParam(value="email") String email){
		System.out.println(email);
		if(userService.findByEmail(email) !=null){
			User user = userService.findByEmail(email);
			String password = user.getPassword();			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setTo(user.getEmail());
	        mailMessage.setReplyTo("elidrissithai@gmail.com");
	        mailMessage.setFrom("elidrissithai@gmail.com");
	        mailMessage.setSubject("Recuperation de mot de passe");
	        mailMessage.setText("Login : "+user.getEmail()+" Password : "+password);
	        javaMailSender.send(mailMessage);
			System.out.println("End sending mail");
			
			return new ResponseEntity<User>(user , HttpStatus.OK);
		}
		System.out.println("the user is not find");
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
//	boolean test =false ;
//	if(user instanceof Etudiant)
//	{
//		test =true;
//		etudiantMetier.Update((Etudiant) user);
//		
//	}
//	if(user instanceof EnsPermanent)
//	{
//		test =true;
//		ensPernamentMetier.update((EnsPermanent) user);
//	}
//	if(user instanceof EnsVacataire)
//	{
//		test =true;
//		ensVacataireMetier.update((EnsVacataire) user);
//	}
//	if(!test){
//		userService.updateUser(id,user);
//	}
}