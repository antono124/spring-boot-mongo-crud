package com.antogeo.springbootmongocrud.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {



}
