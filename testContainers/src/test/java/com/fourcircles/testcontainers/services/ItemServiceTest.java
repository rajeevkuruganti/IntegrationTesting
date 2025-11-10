package com.fourcircles.testcontainers.services;


import com.fourcircles.testcontainers.entities.Item;
import com.fourcircles.testcontainers.repository.ItemRepository;
import org.hibernate.annotations.processing.SQL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Testcontainers
@SQL('schema.sql')
class ItemServiceTest {

    static PostgreSQLContainer<?> postgres =  new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:latest")
    ).withInitScript("schema.sql");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        itemRepository.deleteAll();
    }

    @Test
    void shouldGetAllItem() {
        Item item = new Item(null, "the night watch", "Painting",2346383.23);
        itemRepository.save(item);
        item = new Item(null,"Thinker","Sculpture",34899999.90);
        itemRepository.save(item);
        itemRepository.findAll().forEach(System.out::println);
       assertEquals(2,itemRepository.findAll().size());
    }
}
