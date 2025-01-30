package com.example.pos_system.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos_system.dto.ItemRequestDto;
import com.example.pos_system.entity.Category;
import com.example.pos_system.entity.Item;
import com.example.pos_system.repository.CategoryRepository;
import com.example.pos_system.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Item addItem(ItemRequestDto itemRequestDto) {
        
    Item item = new Item();
    item.setName(itemRequestDto.getName());
    item.setPrice(itemRequestDto.getPrice());
    item.setUnit(itemRequestDto.getUnit());
    item.setStock(itemRequestDto.getStock());
    item.setExpiryDate(itemRequestDto.getExpiryDate());

    if (itemRequestDto.getCategoryId() != null) {
        Category category = categoryRepository.findById(itemRequestDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID: " + itemRequestDto.getCategoryId()));
        item.setCategory(category);
    }

    return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, ItemRequestDto item) {
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + id));
        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setUnit(item.getUnit());
        existingItem.setStock(item.getStock());
        existingItem.setExpiryDate(item.getExpiryDate());
        //existingItem.setUpdatedAt(Timestamp.now());
        if (item.getCategoryId() != null) {
            Category category = categoryRepository.findById(item.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid category ID: " + item.getCategoryId()));
            existingItem.setCategory(category);
        }
        
        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new IllegalArgumentException("Item not found with ID: " + id);
        }
        itemRepository.deleteById(id);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + id));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    @Override
    public List<Item> getItemsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid category ID: " + categoryId));
        return itemRepository.findByCategory(category);
    }
}
