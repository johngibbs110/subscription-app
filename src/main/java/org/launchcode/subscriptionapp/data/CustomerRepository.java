package org.launchcode.subscriptionapp.data;

import org.launchcode.subscriptionapp.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
