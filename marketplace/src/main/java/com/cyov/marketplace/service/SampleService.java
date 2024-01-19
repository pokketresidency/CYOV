package com.cyov.marketplace.service;

import com.cyov.marketplace.model.entity.SampleEntity;
import com.cyov.marketplace.repository.SampleRepository;
import com.cyov.marketplace.utils.RedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SampleService {
    private final SampleRepository bookRepository;

    private final RedisUtility redisUtility;

    @Autowired
    public SampleService(SampleRepository bookRepository, RedisUtility redisUtility) {
        this.bookRepository = bookRepository;
        this.redisUtility = redisUtility;
    }

    public List<SampleEntity> findAllBooks() {
        List<SampleEntity> result =  bookRepository.findAll();

        redisUtility.setValue("testingData", result);

        var res = redisUtility.getValue("testingData");

        return result;
    }
}
