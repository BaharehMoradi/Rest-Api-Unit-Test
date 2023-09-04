package com.example.restapiunittest.repository;

import com.example.restapiunittest.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
