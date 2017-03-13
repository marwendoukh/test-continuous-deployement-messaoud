package services;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import interfaces.AdminServiceLocal;
import interfaces.AdminServiceRemote;
import persistance.Admin;


@Stateless
@LocalBean
public class AdminService implements AdminServiceLocal, AdminServiceRemote {
    
	@PersistenceContext(unitName="AdminWeb-ejb")
	EntityManager em;
	
	
	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Admin identifierAdmin(String login, String password) {
		Admin ad = null;
		String requete = "select e from Admin e where e.login=:x and e.password=:y ";
		try {
			ad = em.createQuery(requete, Admin.class).setParameter("x", login)
					.setParameter("y", password)
					.getSingleResult();
			System.out.println("te5dem");
			
		} catch (NoResultException ex) {
			System.out.println("aucun objet avec ce login et ce mdp");
		}

		return ad;
	}
	@Override
	public void ajouterAdmin(Admin admin) {
		
		em.persist(admin);
	}
	
	
}
