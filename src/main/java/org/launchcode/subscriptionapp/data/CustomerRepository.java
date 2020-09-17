package org.launchcode.subscriptionapp.data;

import org.launchcode.subscriptionapp.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByLastName (@Param("lastName") String lastName);

}
