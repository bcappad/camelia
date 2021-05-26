package com.camelia.camelia.repository;

import com.camelia.camelia.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
