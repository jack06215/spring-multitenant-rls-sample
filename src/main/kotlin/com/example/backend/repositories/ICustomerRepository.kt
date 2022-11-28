package com.example.backend.model.repositories

import com.example.backend.model.Customer
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface ICustomerRepository : CrudRepository<Customer, Long> {

  @Async
  @Query("select c from Customer c")
  fun findAllAsync(): CompletableFuture<List<Customer>>
}