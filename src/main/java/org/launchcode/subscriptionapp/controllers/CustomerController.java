package org.launchcode.subscriptionapp.controllers;

import org.launchcode.subscriptionapp.data.CustomerData;
import org.launchcode.subscriptionapp.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("display-customers")
    public String displayCustomers(Model model) {
        model.addAttribute("customers", CustomerData.getAll());
        return "customers/display-customers";
    }

    @GetMapping("add-customer")
    public String displayAddCustomerForm(Model model) {
        return "customers/add-customer";
    }

    @PostMapping("add-customer")
    public String createCustomer(@ModelAttribute Customer newCustomer) {
        CustomerData.addCustomer(newCustomer);
        return "redirect:/display-customers";
    }

}
