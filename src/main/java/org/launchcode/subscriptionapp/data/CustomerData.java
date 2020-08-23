package org.launchcode.subscriptionapp.data;

import org.launchcode.subscriptionapp.models.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerData {

    private static final Map<Integer, Customer> customers = new HashMap<>();

    public static void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public static Customer getById(int id) {
        return customers.get(id);
    }

    public static Collection<Customer> getAll() {
        return customers.values();
    }

}
