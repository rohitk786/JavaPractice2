package com.javaTechie.springCassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.javaTechie.springCassandra.model.User;

public interface UserRepository extends CassandraRepository<User, Integer>{

	@AllowFiltering
	List<User> findByAgeGreaterThan(int age);

}
