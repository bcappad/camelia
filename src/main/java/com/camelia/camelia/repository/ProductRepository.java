package com.camelia.camelia.repository;

import com.camelia.camelia.model.Product;
import com.camelia.camelia.model.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("from Product where name like %:name%")
    Iterable<Product> getProductsByNameLike(@Param("name") String name);
}
