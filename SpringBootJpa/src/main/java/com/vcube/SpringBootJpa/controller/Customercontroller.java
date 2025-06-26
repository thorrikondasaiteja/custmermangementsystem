package com.vcube.SpringBootJpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.SpringBootJpa.Exception.ResourceNotFoundexception;
import com.vcube.SpringBootJpa.model.Customer;
import com.vcube.SpringBootJpa.repo.CustomerRepository;

@RestController
@RequestMapping("/api/v1") 

public class Customercontroller {
	@Autowired
	CustomerRepository customerRepository;
//	
//	@GetMapping("/findbyid/{cid}")
//    public Optional<Customer> Getcusbyid(@PathVariable("cid") int cid) throws ResourceNotFoundexception){
//        return customerRepository.findById(cid);
//    }@DeleteMapping("/delet/{cid}")

	
	@DeleteMapping("delete/{cid}")
	String DeleteMapping(@PathVariable("cid") int cid) {
		customerRepository.deleteById(cid);
		return "deleted ";
		
	}
	@PutMapping("/update/{cid}")
	ResponseEntity<Customer> updateCustomer(@RequestBody Customer customerreq ,@PathVariable("cid")  int cid) throws ResourceNotFoundexception{
		
	
		  Customer customer = customerRepository.findById(cid)
	                .orElseThrow(() -> new ResourceNotFoundexception("Customer not found with ID"));
		  customer.setCname(customerreq.getCname());
		  customer.setCphoneno(customerreq.getCphoneno());
		  customer.setCsal(customerreq.getCsal());
		  final Customer updatedcustomer=customerRepository.save(customer);
			 
			 
		 
		
		return ResponseEntity.ok(updatedcustomer);
		
	}
	  @GetMapping("/findbyid/{cid}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable("cid") int cid) throws ResourceNotFoundexception {
	        Customer customer = customerRepository.findById(cid)
	                .orElseThrow(() -> new ResourceNotFoundexception("Customer not found with ID"));
	        return ResponseEntity.ok(customer);
	    }
//    

	@GetMapping("/getallcus")
	List<Customer> GetCustomer(){
		List<Customer> cus=new ArrayList<>();
		cus=customerRepository.findAll();
		return cus;
	}
		
   		
////	}
//	@GetMapping("/GetHighSalaryEmp")
//	public List<Customer> getEmployeesWithHighSalary() { 
//	    return customerRepository.findByCsalGreaterThan1(70000);
//	}
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)

	Customer createCustomer(@RequestBody Customer customer){
		customer=	customerRepository.save(customer);
		
	return customer;
		
	}

}


