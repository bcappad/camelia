package com.camelia.camelia.repository;

import com.camelia.camelia.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
