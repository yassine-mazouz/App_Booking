package com.example.demo.dao;

import com.example.demo.models.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepo extends JpaRepository<Page,Integer> {

}
