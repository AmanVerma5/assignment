package com.customer.customerManagement.service;

import com.customer.customerManagement.model.Customer;
import com.customer.customerManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public ResponseEntity<Customer> getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return ResponseEntity.ok(customer);
    }

    public ResponseEntity<Customer> updateCustomer(String id, Customer updtaedCustomer) {

        Customer existingCustomer=customerRepository.findById(id).get();

        existingCustomer.setFirst_name(updtaedCustomer.getFirst_name());
        existingCustomer.setLast_name(updtaedCustomer.getLast_name());
        existingCustomer.setState(updtaedCustomer.getState());
        existingCustomer.setCity(updtaedCustomer.getCity());
        existingCustomer.setAddress(updtaedCustomer.getAddress());
        existingCustomer.setStreet(updtaedCustomer.getStreet());
        existingCustomer.setEmail(updtaedCustomer.getEmail());
        existingCustomer.setPhone(updtaedCustomer.getPhone());

        customerRepository.save(existingCustomer);

        return ResponseEntity.ok(existingCustomer);


    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
