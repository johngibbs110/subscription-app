package org.launchcode.subscriptionapp.controllers;

import org.launchcode.subscriptionapp.data.CustomerRepository;
import org.launchcode.subscriptionapp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("edit-customer/{id}")
    public String displayEditCustomerForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerRepository.findById(id).get();
        model.addAttribute("title", "Edit Customer");
        model.addAttribute("customer", customer);
        return "customers/edit-customer";
    }

    @RequestMapping(value = "edit-customer/{id}", method = RequestMethod.POST)
    public String updateExistingCustomer(@PathVariable("id") int id, @ModelAttribute @Valid Customer newCustomer, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Customer");
            return "customers/edit-customer";
        }
        customerRepository.save(newCustomer);
        return "redirect:/display-customers";
    }

    @GetMapping("delete-customer/{id}")
    public String processDeleteCustomer(@PathVariable("id") int id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
        return "redirect:/display-customers";
    }

}
