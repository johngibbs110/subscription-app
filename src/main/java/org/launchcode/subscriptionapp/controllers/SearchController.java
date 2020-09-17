package org.launchcode.subscriptionapp.controllers;

import org.launchcode.subscriptionapp.data.CustomerRepository;
import org.launchcode.subscriptionapp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("search-customers")
    public String searchCustomers(Model model) {
        model.addAttribute("title", "Search Customers");
        return "customers/search-customers";
    }

    @RequestMapping(value = "search-customers", method = RequestMethod.POST)
    public String displaySearchResults(Model model, @RequestParam String searchLastName) {
        List<Customer> customers = customerRepository.findByLastName(searchLastName);
        model.addAttribute("title", "Search Customers");
        model.addAttribute("customers", customers);
        return "customers/search-customers";
    }

}
