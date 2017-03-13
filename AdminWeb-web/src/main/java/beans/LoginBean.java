package beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import interfaces.AdminServiceLocal;
import persistance.Admin;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {
	
	private String login;
	private String password;
	private Admin 	admin;
	
	@EJB
	AdminServiceLocal asl;
	
	
	public String doLogin(){
		String navigateTo=""; 
		admin=asl.identifierAdmin(login, password);
		if(admin!=null){
			navigateTo="/Dashboard/Dashboard";
			System.out.println("hahahahah");
			
		}
		else
			navigateTo="/Error";
		return navigateTo;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
