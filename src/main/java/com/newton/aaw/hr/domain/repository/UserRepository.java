package com.newton.aaw.hr.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newton.aaw.hr.domain.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

}
