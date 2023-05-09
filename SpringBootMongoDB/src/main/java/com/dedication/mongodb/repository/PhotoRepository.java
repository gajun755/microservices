package com.dedication.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dedication.mongodb.collection.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {

	
}
