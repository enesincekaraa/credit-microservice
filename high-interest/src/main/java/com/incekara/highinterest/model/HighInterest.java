package com.incekara.highinterest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class HighInterest {

    @Id
    private  Long id;

    @Column(name = "credit_type")
    private  String creditType;

    private BigDecimal interestRate;

    private  String environment;

    public HighInterest() {
    }

    public HighInterest(Long id, String creditType, BigDecimal interestRate, String environment) {
        this.id = id;
        this.creditType = creditType;
        this.interestRate = interestRate;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
