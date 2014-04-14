package com.bookstore.userStrategy;

import java.util.HashMap;
import java.util.Map;

import com.bookstore.entity.Customer;
import com.bookstore.security.PasswordHash;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class CustomerManager implements UserStrategy{
	
	private SessionBeanFacadeLocal ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
	private PasswordHash passwordHash = new PasswordHash();
	private Map<String, Object> session = WebSessionFactory.getWebSessionInstance();
	
	@Override
	public boolean login(String email, String password) {
		Customer customer = ejbSessionBean.authenticateCust(email);
		if(passwordHash.authenticate(customer.getPassword(), customer.getSalt(), password)){
			session.put("customer", customer);
			//listCategories();
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void register(String email, String password, String firstName, String lastName) {
		HashMap<String, String> map = passwordHash.hashPassword(password);
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(map.get("password"));
		customer.setSalt(map.get("salt"));
		ejbSessionBean.persist(customer);
		session = ActionContext.getContext().getSession();
		session.put("customer", customer);
		//listCategories();
	}

	@Override
	public void logout() {
		session = ActionContext.getContext().getSession();
		session.remove("customer");
		session.clear();
	}

}
