package com.zemoso.springdemo.controller;


import com.zemoso.springdemo.dao.CustomerDAO;
import com.zemoso.springdemo.entity.Customer;
import com.zemoso.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel)
    {
        List<Customer> customers=customerService.getCustomers();

        theModel.addAttribute("customers",customers);

        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel)
    {
        Customer customer=new Customer();

        theModel.addAttribute("customer",customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int theId,Model theModel)
    {
        Customer theCustomer=customerService.getCustomer(theId);

        theModel.addAttribute("customer",theCustomer);

        return "customer-form";

    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId,Model theModel)
    {
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";

    }
}
