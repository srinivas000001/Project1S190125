package com.niit.Project1BackendS190124;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.configuration.H2Config;
import com.niit.daoimpl.ProductDAOImpl;
import com.niit.model.Product;
import com.niit.services.ProductService;
import com.niit.servicesimpl.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(H2Config.class,ProductDAOImpl.class,ProductServiceImpl.class);
        ProductService productService=(ProductService)context.getBean("productServiceImpl");
        Product product=new Product();
        product.setProductName("pencil");
        product.setPrice(60);
        product.setQuantity(100);
        product.setProductDesc("some description about pencil");
        productService.saveProduct(product);
        
     }
}
