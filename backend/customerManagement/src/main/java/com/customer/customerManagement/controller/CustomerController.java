package com.customer.customerManagement.controller;

import com.customer.customerManagement.model.Customer;
import com.customer.customerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //add new customer rest api
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    //update customer api
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id,@RequestBody Customer updtaedCustomer){
        return customerService.updateCustomer(id,updtaedCustomer);
    }

    //get customer by id(phone) rest api
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }



}
