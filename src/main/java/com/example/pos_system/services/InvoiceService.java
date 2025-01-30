package com.example.pos_system.services;

import java.util.List;

import com.example.pos_system.dto.InvoiceDto;

public interface InvoiceService {
    InvoiceDto createInvoice(InvoiceDto invoiceDTO);

    InvoiceDto getInvoiceById(int id);

    //InvoiceDto getInvoiceByNumber(String invoiceNumber);

    List<InvoiceDto> getAllInvoices();

    void deleteInvoice(int id);
}
