package com.example.pos_system.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pos_system.entity.Category;
import com.example.pos_system.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{
    List<Item> findByCategory(Category category);
    //boolean existsByName(String name);
    //Item save(ItemRequestDto item);
    Optional<Item> findById(int id);
}
