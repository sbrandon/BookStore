package com.bookstore.userStrategy;

public class UserContext {
	
	private UserStrategy strategy;
	
	public UserContext(UserStrategy strategy){
		this.strategy = strategy;
	}
	
	public boolean login(String email, String password){
		return strategy.login(email, password);
	}
	
	public void register(String email, String password, String firstName, String lastName){
		strategy.register(email, password, firstName, lastName);
	}
	
	public void logout(){
		strategy.logout();
	}
	
}
