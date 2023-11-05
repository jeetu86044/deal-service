package com.demo.dealService.repository;

import com.demo.dealService.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealRepository extends JpaRepository<Deal, Long> {

    Optional<Deal> findAllByDealId(String dealId);
}
