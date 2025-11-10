
package com.fourcircles.testcontainers.repository;


import com.fourcircles.testcontainers.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
