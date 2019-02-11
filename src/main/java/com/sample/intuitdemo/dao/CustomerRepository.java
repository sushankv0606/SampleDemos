package com.sample.intuitdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.intuitdemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public List<Customer> findByType(String type);

}
