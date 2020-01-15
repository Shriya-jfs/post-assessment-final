package com.demo;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.demo.model.Product;

public class Application {
	static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
		setUpSessionFactory();
		//saveProduct();
		updateProduct();
		//deleteProduct();
		getProducts();
	}

	public static void setUpSessionFactory() {
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void getProducts() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query selectQuery = session.createQuery("from Product");
		List<Product> products = (List<Product>)selectQuery.list();
		for(Product product: products) {
			System.out.println(product);
			
		}
		transaction.commit();
		
	}
	public static void saveProduct() {
	
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = new Product();
	    product.setProductId("P1");
        product.setProductName("THE ALCHEMIST");
        product.setProductPrice(200);
		product.setProductId("P2");
		product.setProductName("POWER OF NOW");
		product.setProductPrice(250);
		session.save(product);
		transaction.commit();
		
	}
	public static void updateProduct() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = (Product)session.get(Product.class, "P1");
		product.setProductName("LIFE OF PI");
		transaction.commit();
		
	}
	public static void deleteProduct() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = (Product)session.get(Product.class, "P1");
		product.setProductName("LIFE OF PI");
		session.delete(product);
		transaction.commit();
		
	}
}
