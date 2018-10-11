package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {
	void saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(int id);
	void deleteProduct(Product product);
	void editProduct(Product product);

}
