package com.mydomain.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mydomain.model.User;

@Path("/user")
public class UserService {

	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> getUsers() {
		System.out.println("Inside getUsers..................");
		User user = new User();
		user.setName("FirstRestUser");
		List<User> users = new ArrayList<User>();

		users.add(user);
		return users;
	}

}