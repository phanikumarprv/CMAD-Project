package com.mydomain.service;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.mydomain.dao.UserServiceDAO;
import com.mydomain.model.User;

public class UserServiceTest {
	
	
	@Test
	public void testGetUser() {
		
		UserServiceDAO mockUserServiceDAO = mock(UserServiceDAO.class);
		User user = new User();
		user.setName("Test");
		when(mockUserServiceDAO.getUser(anyInt())).thenReturn(user);
		
		UserService userService = new UserService();
		userService.setUserServiceDao(mockUserServiceDAO);
		User user1 = userService.getUser(1);
		Assert.assertEquals("Test", user1.getName());
		
	}
	
	@Test//(expected=IllegalArgumentException.class)
	public void testGetUserUsingNullAsId() {
		UserServiceDAO mockUserServiceDAO = mock(UserServiceDAO.class);
		when(mockUserServiceDAO.getUser(null)).thenThrow(new IllegalArgumentException("User Id cannot be Null"));
		
		UserService userService = new UserService();
		userService.setUserServiceDao(mockUserServiceDAO);
		User user1 = userService.getUser(null);
		Assert.assertEquals("Test", user1.getName());
	}
}
