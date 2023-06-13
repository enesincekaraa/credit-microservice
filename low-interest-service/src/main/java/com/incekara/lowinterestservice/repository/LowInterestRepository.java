package com.incekara.lowinterestservice.repository;

import com.incekara.lowinterestservice.model.LowInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LowInterestRepository extends JpaRepository<LowInterest,Long> {
    LowInterest findByCreditType(String creditType);
}
