package com.example.pos_system.services;

import java.util.List;

import com.example.pos_system.dto.ItemRequestDto;
import com.example.pos_system.entity.Item;

public interface ItemService {
    Item addItem(ItemRequestDto item);

    Item updateItem(Long id, ItemRequestDto item);

    void deleteItem(Long id);

    Item getItemById(Long id);

    List<Item> getAllItems();

    List<Item> getItemsByCategory(Long categoryId);
}
