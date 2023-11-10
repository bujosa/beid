package com.bujosa.beid.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bujosa.beid.user.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{}
