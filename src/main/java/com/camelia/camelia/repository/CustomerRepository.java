package com.camelia.camelia.repository;

import com.camelia.camelia.model.Customer;
import com.camelia.camelia.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("from Customer where name like %:name%")
    Iterable<Customer> getCustomersByNameLike(@Param("name") String name);
}
