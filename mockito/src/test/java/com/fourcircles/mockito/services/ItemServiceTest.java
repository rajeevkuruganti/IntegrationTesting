package com.fourcircles.mockito.services;


import com.fourcircles.mockito.entities.Item;
import com.fourcircles.mockito.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    private static List<Item> items;

    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ItemService itemService;


    @Test
    void testGetItemById() {
        // Given
        Long itemId = 23L;
//    Item mockItem = new Item();
        Item mockItem = new Item(23,"The Count of Monte Cristo", "book",
                1.23, "classic illustrated");

        // When: Define the behavior of the mocked method
        when(itemRepository.findById(itemId)).thenReturn(Optional.of(mockItem));

        // Then: Call the service method and assert the result
        Optional<Item> foundItem = itemService.findById(itemId);
//    System.out.println(foundItem.get().getName());
        assertEquals(mockItem.getId(), foundItem.get().getId());
    }
}
