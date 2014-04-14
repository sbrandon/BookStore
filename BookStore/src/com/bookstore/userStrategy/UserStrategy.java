/*
 * Interface to implement strategy pattern
 */
package com.bookstore.userStrategy;

public interface UserStrategy {

	public boolean login(String email, String password);
	public void register(String email, String password, String firstName, String lastName);
	public void logout();
	
}
