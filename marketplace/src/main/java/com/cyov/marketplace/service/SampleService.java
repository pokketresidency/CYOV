package com.cyov.marketplace.service;

import com.cyov.marketplace.model.entity.SampleEntity;
import com.cyov.marketplace.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SampleService {
    private final SampleRepository bookRepository;

    @Autowired
    public SampleService(SampleRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<SampleEntity> findAllBooks() {
        List<SampleEntity> result =  bookRepository.findAll();

        return result;
    }
}
