package com.tuportfolio.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuportfolio.portfolio.models.Drawing;

public interface DrawingRepository extends JpaRepository<Drawing, Long> {

}