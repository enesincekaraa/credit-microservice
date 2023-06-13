package com.incekara.highinterest.repository;

import com.incekara.highinterest.model.HighInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface HighInterestRepository extends JpaRepository<HighInterest,Long> {

    HighInterest findByCreditType(String creditType);


}
