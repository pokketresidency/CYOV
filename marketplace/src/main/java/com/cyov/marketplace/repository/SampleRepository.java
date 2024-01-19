package com.cyov.marketplace.repository;

import com.cyov.marketplace.model.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
}
