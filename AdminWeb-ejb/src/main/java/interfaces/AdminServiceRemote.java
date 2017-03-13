package interfaces;



import javax.ejb.Remote;

import persistance.Admin;



@Remote
public interface AdminServiceRemote {
	Admin identifierAdmin(String login, String password);
	void ajouterAdmin(Admin admin);

}
