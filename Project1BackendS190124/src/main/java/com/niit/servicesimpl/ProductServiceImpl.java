package com.niit.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;
import com.niit.services.ProductService;

public class ProductServiceImpl implements ProductService
{
	public ProductServiceImpl(){
		System.out.println("productServiceimpl object has created");
	}
	@Autowired
private ProductDAO productDAO;


	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
		
		
	}


	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}


	public Product getProductById(int id) {
		return productDAO.getProductById(id);
	}


	public void deleteProduct(int id) {
		Product product=getProductById(id);
		productDAO.deleteProduct(product);
	}


	public void updateProduct(Product product) {
		productDAO.editProduct(product);
		
		
	}


}
