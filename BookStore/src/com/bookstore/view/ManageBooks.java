package com.bookstore.view;

import com.opensymphony.xwork2.Preparable;

public class ManageBooks implements Preparable{

	@Override
	public void prepare() throws Exception {
		
	}
	
	public String addBook(){
		return "success";
	}

}
