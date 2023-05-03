package com.market.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entity.Lead;



public interface LeadRepository extends JpaRepository<Lead, Long> {

}
