package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO
{

	public ProductDAOImpl(){
		System.out.println("productDaoimpl object has created");
		
	}
	
	@Autowired
private SessionFactory  sessionFactory;

	public void saveProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.save(product);
		
		
		
		
	}

	public Product getProductById(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		return product;
		
	}

	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		
		Query query=session.createQuery("from Product");
		query.list();
		List<Product> products=query.list();
		return products;
		
	}

	public void deleteProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(product);
		
	}

	public void editProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		
	}


	


}
