package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class controller {

    @Autowired
    private final CustomerService customerService;

    public controller(CustomerService customerService) {
        this.customerService = customerService;
    }

    // [Read] + SAFE METHOD
    @GetMapping("/all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    // [Read] + SAFE METHOD
    @GetMapping("/id/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id){
        return customerService.getCustomer(id);
    }

    // [Create] + Transactional Method...
    @PostMapping("/create")
    public Customer createNewCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    // [Update] + Transactional Method...
    @PutMapping("/update/id/{id}")
    public Customer updateCustomer(@PathVariable("id") Integer id,@RequestBody Customer customer){
        System.out.println(id);
        return customerService.updateCustomer(id,customer);
    }

    // [Delete] + UnSafe Method
    @DeleteMapping("/id/{randomid}")
    public String deleteCustomer(@PathVariable("randomid") Integer id){
        return customerService.removeCustomer(id);
    }

}
