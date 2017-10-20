package com.drongma.shoppingbackend.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.drongma.shoppingbackend.dao.UserDAO;
import com.drongma.shoppingbackend.dto.Address;
import com.drongma.shoppingbackend.dto.Cart;
import com.drongma.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.drongma.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
/*
	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Ngawang");
		user.setLastName("Yeshi");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
		address = new Address();
		address.setAddressLineOne("Tibetan youth hostel, Koramangala");
		address.setAddressLineTwo("Near Mandri classic");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560047");
		address.setBilling(true);
		
		cart = new Cart();
		
		// linked the address with the user
		address.setUser(user);
		
		// linked the cart with the user
		cart.setUser(user);
		// link the user with the cart
		user.setCart(cart);
		
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.add(user));	
		// add the address
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));

				
		// add the shipping address
		address = new Address();
		address.setAddressLineOne("Tibetan youth hostel, Koramangala");
		address.setAddressLineTwo("Near Mandri classic");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560047");
		address.setBilling(true);
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
	}
	
	

	// working for uni-directional
/*
	@Test
	public void testAddAddress() {
		user = userDAO.get(1);
		
		address = new Address();
		address.setAddressLineOne("Tibetan youth hostel, Koramangala");
		address.setAddressLineTwo("Near Mandri classic");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560047");
		address.setBilling(true);
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
	}
	
	@Test
	public void testUpdateCart() {
		user = userDAO.get(1);
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	} 

*/
	

	
}
