package com.example.pos_system.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos_system.dto.InvoiceDto;
import com.example.pos_system.entity.Invoice;
import com.example.pos_system.entity.Sale;
import com.example.pos_system.repository.InvoiceRepository;
import com.example.pos_system.repository.SaleRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDTO) {
        Sale sale = saleRepository.findById(invoiceDTO.getSaleId())
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        Invoice invoice = new Invoice();
        invoice.setSale(sale);
        invoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        invoice.setTotal(invoiceDTO.getTotal());
        invoice.setDiscount(invoiceDTO.getDiscount());
        invoice.setGrossAmount(invoiceDTO.getGrossAmount());

        Invoice savedInvoice = invoiceRepository.save(invoice);

        return mapToDTO(savedInvoice);
    }

    @Override
    public InvoiceDto getInvoiceById(int id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        return mapToDTO(invoice);
    }

    @Override
    public List<InvoiceDto> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteInvoice(int id) {
        if (!invoiceRepository.existsById(id)) {
            throw new RuntimeException("Invoice not found");
        }
        invoiceRepository.deleteById(id);
    }

    private InvoiceDto mapToDTO(Invoice invoice) {
        InvoiceDto dto = new InvoiceDto();
        dto.setId(invoice.getId());
        dto.setSaleId(invoice.getSale().getId());
        dto.setInvoiceNumber(invoice.getInvoiceNumber());
        dto.setTotal(invoice.getTotal());
        dto.setDiscount(invoice.getDiscount());
        dto.setGrossAmount(invoice.getGrossAmount());
        return dto;
    }
}
