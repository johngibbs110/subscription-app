package org.launchcode.subscriptionapp.controllers;

import org.launchcode.subscriptionapp.data.CustomerData;
import org.launchcode.subscriptionapp.data.CustomerRepository;
import org.launchcode.subscriptionapp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("display-customers")
    public String displayCustomers(Model model) {
        model.addAttribute("title", "Customers");
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/display-customers";
    }

    @GetMapping("add-customer")
    public String displayAddCustomerForm(Model model) {
        model.addAttribute("title", "Add Customer");
        model.addAttribute(new Customer());
        return "customers/add-customer";
    }

    @PostMapping("add-customer")
    public String createCustomer(@ModelAttribute @Valid Customer newCustomer, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Customer");
            return "customers/add-customer";
        }
        customerRepository.save(newCustomer);
        return "redirect:/display-customers";
    }

    @GetMapping("edit-customer")
    public String editCustomer(Model model) {
        model.addAttribute("title", "Edit Customer");
        return "customers/edit-customer";
    }

}
