package com.bookstore.interceptor;

import java.util.Map;

import com.bookstore.entity.Customer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CustomerLoginInterceptor implements Interceptor {

	private static final long serialVersionUID = -8728529572631782065L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
		Customer customer = (Customer) sessionAttributes.get("customer");
		if(customer == null){
			return Action.LOGIN;
		}
		else{
			return invocation.invoke();
		}
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}
}
