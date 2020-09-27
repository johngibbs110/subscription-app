package org.launchcode.subscriptionapp.data;

import org.launchcode.subscriptionapp.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    Owner findByUsername (String username);

}
