package com.cyov.marketplace.controller;

import com.cyov.marketplace.model.entity.SampleEntity;
import com.cyov.marketplace.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class MarketplaceController {
    private final SampleService bookService;

    @Autowired
    public MarketplaceController(SampleService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<SampleEntity> getAllBooks() {
        return bookService.findAllBooks();
    }

}

