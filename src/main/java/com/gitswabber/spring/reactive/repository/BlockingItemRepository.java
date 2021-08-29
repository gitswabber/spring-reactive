package com.gitswabber.spring.reactive.repository;

import org.springframework.data.repository.CrudRepository;

// blocking repository
public interface BlockingItemRepository extends CrudRepository<Item, String> {
}
