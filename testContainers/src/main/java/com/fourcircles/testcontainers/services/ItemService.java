package com.fourcircles.testcontainers.services;



import com.fourcircles.testcontainers.entities.Item;
import com.fourcircles.testcontainers.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
   private ItemRepository itemRepository;
    public ItemService() {

    }
    public Optional<Item> findById(Long itemId) {
        return itemRepository.findById(itemId);
    }

    public Item saveOne(Item item) {
       return  itemRepository.save(item);
    }
}
