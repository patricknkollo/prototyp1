package com.shopping.prototyp1.services;


import com.shopping.prototyp1.entities.Customer;
import com.shopping.prototyp1.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class CustomerService {

  Logger logger = LoggerFactory.getLogger(CustomerService.class);

  @Autowired
  CustomerRepository repository;

  @Transactional
  public ResponseEntity<Customer> saveCustomer (Customer customer){
    Customer savedCustomer = repository.save(customer);
    if (savedCustomer == null){
      logger.info("new customer couldn't be created because the customer is null! ");
      return new ResponseEntity<Customer>(savedCustomer, HttpStatus.NO_CONTENT);
    }
      logger.info("new customer was created with the name {} and the email {}", customer.getCustomerName(), customer.getEmail());
    return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
  }

  @Transactional
  public ResponseEntity<List<Customer>> getCustomerByName(String name){
    if(name.isBlank()){
      logger.info("the given name schould not be empty, blank or null...please check it one more time!");
      return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }
    List<Customer> customerWithName = repository.findAll()
        .stream()
        .filter(customer -> customer.getCustomerName().equals(name))
        .collect(
        Collectors.toList());
    if(customerWithName==null){
      logger.info("the given name schould not be empty, blank or null...please check it one more time!");
      return new ResponseEntity<>(customerWithName, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(customerWithName, HttpStatus.FOUND);
  }

  @Transactional
  public ResponseEntity<List<Customer>> getAllCustomers(){
    List<Customer> customerWithName = repository.findAll();
    if(customerWithName==null){
      logger.info("the given name schould not be empty, blank or null...please check it one more time!");
      return new ResponseEntity<>(customerWithName, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(customerWithName, HttpStatus.FOUND);
  }
  @Transactional
  public void deleteCustomerByID(Long id){
    repository.deleteById(id);
    logger.info("the customer with the id {}", id);
  }
  @Transactional
  public ResponseEntity<Optional<Customer>> updateCustomer(Customer customer, Long id){
    Optional<Customer> optionalCustomer = repository.findById(id);
    if (optionalCustomer.isPresent()){
      optionalCustomer.get().setCustomerName(customer.getCustomerName());
      optionalCustomer.get().setAddress(customer.getAddress());
      optionalCustomer.get().setCreditCardInfo(customer.getCreditCardInfo());
      optionalCustomer.get().setEmail(customer.getEmail());
      optionalCustomer.get().setPhone(customer.getPhone());
      optionalCustomer.get().setShippingInfo(customer.getShippingInfo());
      repository.save(optionalCustomer.get());
      return new ResponseEntity<>(optionalCustomer, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
  }
}
