package com.example.gfaBe.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gfaBe.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}