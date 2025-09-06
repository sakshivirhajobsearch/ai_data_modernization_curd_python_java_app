package com.ai.data.modernization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.data.modernization.data.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
