package com.example.pos_system.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pos_system.dto.SaleItemRequestDto;
import com.example.pos_system.dto.SaleRequestDto;
import com.example.pos_system.entity.Item;
import com.example.pos_system.entity.Sale;
import com.example.pos_system.entity.SaleItem;
import com.example.pos_system.entity.User;
import com.example.pos_system.repository.ItemRepository;
import com.example.pos_system.repository.SaleItemRepository;
import com.example.pos_system.repository.SaleRepository;
import com.example.pos_system.repository.UserRepository;

@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public Sale createSale(SaleRequestDto saleRequestDto) {
        // Validate User
        User user = userRepository.findById(saleRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Sale sale = new Sale();
        sale.setUser(user);
        sale.setDiscount(saleRequestDto.getDiscount());

        BigDecimal totalAmount = BigDecimal.ZERO;
        List<SaleItem> saleItems = new ArrayList<>();

        for (SaleItemRequestDto saleItemRequest : saleRequestDto.getSaleItems()) {
            Item item = itemRepository.findById(saleItemRequest.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            // Check Stock Availability
            if (item.getStock() < saleItemRequest.getQuantity()) {
                throw new RuntimeException("Insufficient stock for item: " + item.getName());
            }

            // Deduct Stock
            item.setStock(item.getStock() - saleItemRequest.getQuantity());
            itemRepository.save(item);

            // Create SaleItem
            SaleItem saleItem = new SaleItem();
            saleItem.setSale(sale);
            saleItem.setItem(item);
            saleItem.setQuantity(saleItemRequest.getQuantity());
            saleItem.setUnitPrice(item.getPrice());
            saleItem.setTotal(item.getPrice().multiply(BigDecimal.valueOf(saleItemRequest.getQuantity())));

            totalAmount = totalAmount.add(saleItem.getTotal());
            saleItems.add(saleItem);
        }

        sale.setTotalAmount(totalAmount.subtract(sale.getDiscount()));
        sale.setSaleItems(saleItems);

        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public List<Sale> getSalesByUserId(int userId) {
        return saleRepository.findByUserId(userId);
    }

    @Override
    public List<SaleItem> getSaleItems(int saleId) {
        return saleItemRepository.findBySaleId(saleId);
    }

}
