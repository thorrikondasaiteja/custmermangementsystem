package com.vcube.SpringBootJpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.SpringBootJpa.model.Customer;
@Repository

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
//    List<Customer> findByEsalGreaterThan(double esal);



//	public List<Customer> findByCsalGreaterThan1(int csal);
//
//	



	
}
