package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import interfaces.AdminServiceLocal;
import persistance.Admin;

@SessionScoped
@ManagedBean
public class AjoutAdmin {
	
	
	@EJB
	private AdminServiceLocal asl;
	private Admin admin;
	private String login;
	private String password;
	private Integer cin;
	private String nom;
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@PostConstruct
	public void init(){
		System.out.print("hani bech n3mal new admin");
		admin=new Admin();
		System.out.print("hani  3malt new admin");

	}
	public String AjouterAdmin(){
 		 
		
		System.out.print("nom "+admin.getNom());

			admin.setCin(cin);
			admin.setLogin(login);
			admin.setNom(nom);
			admin.setPassword(password);
		asl.ajouterAdmin(admin);
		return"";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Integer getCin() {
		return cin;
	}
	public void setCin(Integer cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
