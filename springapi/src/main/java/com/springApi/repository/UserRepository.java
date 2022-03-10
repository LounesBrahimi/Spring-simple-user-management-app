package com.springApi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.springApi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
