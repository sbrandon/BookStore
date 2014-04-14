package com.bookstore.userStrategy;

import java.util.HashMap;
import java.util.Map;

import com.bookstore.entity.Administrator;
import com.bookstore.security.PasswordHash;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class AdminManager implements UserStrategy{
	
	private SessionBeanFacadeLocal ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
	private PasswordHash passwordHash = new PasswordHash();
	private Map<String, Object> session = WebSessionFactory.getWebSessionInstance();
	
	@Override
	public boolean login(String email, String password) {
		Administrator admin = ejbSessionBean.authenticateAdmin(email);
		if(passwordHash.authenticate(admin.getPassword(), admin.getSalt(), password)){
			session.put("admin", admin);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void register(String email, String password, String firstName, String lastName) {
		HashMap<String, String> map = passwordHash.hashPassword(password);
		Administrator admin = new Administrator();
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setEmail(email);
		admin.setPassword(map.get("password"));
		admin.setSalt(map.get("salt"));
		ejbSessionBean.persist(admin);
		session = ActionContext.getContext().getSession();
		session.put("admin", admin);
	}

	@Override
	public void logout() {
		session = ActionContext.getContext().getSession();
		session.remove("admin");
		session.clear();
	}

}
