package interfaces;



import javax.ejb.Local;

import persistance.Admin;

@Local
public interface AdminServiceLocal {
	Admin identifierAdmin(String login, String password);
	void ajouterAdmin(Admin admin);

}
