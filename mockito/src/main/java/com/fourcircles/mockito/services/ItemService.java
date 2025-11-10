package com.fourcircles.mockito.services;

import com.fourcircles.mockito.entities.Item;
import com.fourcircles.mockito.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<Item> findById(Long itemId) {
        return itemRepository.findById(itemId);
    }
}
