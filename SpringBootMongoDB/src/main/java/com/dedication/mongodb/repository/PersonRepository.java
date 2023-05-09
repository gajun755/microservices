package com.dedication.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dedication.mongodb.collection.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

		List<Person>  findByFirstName(String name);

		
		//List<Person> findByAgeBetween(Integer minAge, Integer maxAge);
		
		//address:0 means I don't need
		//address:1 means I need
		@Query(value = "{'age':{$gt:?0,$lt:?1}}",fields = "{addresses:0}")
		List<Person> findPersonByAgeBetween(Integer min, Integer max);

}
