package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    // Dependency Injection
    @Autowired
    private CustomerRepository customerRepo;


    // READ // Check123
    public Customer getCustomer(Integer id){
        return customerRepo.findById(id).get();
    }

    // CREATE
    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    // DELETE
    public String removeCustomer(Integer id){
        customerRepo.deleteById(id);
        return id+" Id is Deleted";
    }

    // UPDATE
    public Customer updateCustomer(Integer id, Customer customer){
        Customer updateCustomer = customerRepo.getReferenceById(id);
        if(customer.getName()!=null){
            updateCustomer.setName(customer.getName());
        }
        if(customer.getAddress()!=null){
            updateCustomer.setAddress(customer.getAddress());
        }
        return customerRepo.save(updateCustomer);
    }

    public List<Customer> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        return all;
    }
}
