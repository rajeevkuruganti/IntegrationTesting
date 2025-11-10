package com.fourcircles.database.services;

import com.fourcircles.database.entities.Item;
import com.fourcircles.database.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ItemServiceTest {


    @Autowired
    private ItemService itemService;

    @Test
    public void givenItem_whenSave_thenGetOk() {
        Item item = new Item(null,"A Tale of Two Cities", "book", 3.95);
        Item savedItem = itemService.saveOne(item);
        Optional<Item> foundItem = itemService.findById(savedItem.getId());
        assertEquals(item.getName(), foundItem.get().getName());

    }
}