package com.shopping.prototyp1.controllers;

import com.shopping.prototyp1.entities.Customer;
import com.shopping.prototyp1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Component
@RequestMapping(path = "/api/customer/controller")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

  @Autowired
  CustomerService service;

  @RequestMapping(path = "/save/customer", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<Customer> saveCustomer (@RequestBody Customer customer){
    return service.saveCustomer(customer);
  }

  @RequestMapping(path = "/customer/name/{thisname}", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<Customer>> getCustomerByName(@PathVariable("thisname") String name){
    return service.getCustomerByName(name);
  }

  @RequestMapping(path = "/all/customers", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<Customer>> getAllCustomers(){
    return service.getAllCustomers();
  }

  @RequestMapping(path = "/update/customer/{thisid}", method = RequestMethod.PUT)
  public @ResponseBody ResponseEntity<Optional<Customer>> updateCustomer(@RequestBody Customer customer, @PathVariable("thisid") Long id){
    return service.updateCustomer(customer, id);
  }

  @RequestMapping(path = "/delete/{thisid}", method = RequestMethod.DELETE)
  public void deletecustomer(@PathVariable("thisid") Long id){
     service.deleteCustomerByID(id);
  }
}
