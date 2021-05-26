package com.camelia.camelia.repository;

import com.camelia.camelia.model.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProviderRepository extends CrudRepository<Provider, Integer> {

    @Query("from Provider where name like %:name%")
    Iterable<Provider> getProviderByNameLike(@Param("name") String name);

    @Query("from Provider where tradename like %:tradename%")
    Iterable<Provider> getProviderByTradenameLike(@Param("tradename") String tradename);
}
