package com.drongma.shoppingbackend.dto;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drongma.shoppingbackend.dao.CartLineDAO;
import com.drongma.shoppingbackend.dao.ProductDAO;

@Service("cartService")
public class Test implements CartLineDAO {
	
	@Autowired
	private CartLineDAO cartlineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CartLine> list(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartLine get(int id) {
		
		return null;
	}

	@Override
	public boolean add(CartLine cartLine) {
		
		sessionFactory.getCurrentSession().persist(cartLine);
		return true;
	}

	@Override
	public boolean update(CartLine cartLine) {
		try{
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean remove(CartLine cartLine) {
	     try{
	    	 sessionFactory.getCurrentSession().delete(cartLine);
	    	 return true;
	     }catch(Exception e)
	     {
	    
	    	 return false;
	     }
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		
		try{
		String query="FROM CartLine WHERE cartId = :cartId AND product.id =: productId";
		return sessionFactory.getCurrentSession().createQuery(query, CartLine.class)
				 .setParameter("cartId", cartId)
				 .setParameter("productId", productId)
				 .getSingleResult();
	}catch(Exception e){
		return null;
	}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query ="FROM CartLine where cartId =:cartId AND available =:available"; 
		return sessionFactory.getCurrentSession()
				 .createQuery(query, CartLine.class)
				   .setParameter("cartId", cartId)
				   .setParameter("available", "abailable")
				        .getResultList();
	}

	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		try{
		 sessionFactory.getCurrentSession().persist(orderDetail);
		 return true;
		
		}catch(Exception e){
			return false;
		}
	}
	
	
	
	
	
	
}