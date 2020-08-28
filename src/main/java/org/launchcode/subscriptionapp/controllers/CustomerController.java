package org.launchcode.subscriptionapp.controllers;

import org.launchcode.subscriptionapp.data.CustomerData;
import org.launchcode.subscriptionapp.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @GetMapping("display-customers")
    public String displayCustomers(Model model) {
        model.addAttribute("customers", CustomerData.getAll());
        model.addAttribute("title", "Customers");
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
        CustomerData.addCustomer(newCustomer);
        return "redirect:/display-customers";
    }

}
