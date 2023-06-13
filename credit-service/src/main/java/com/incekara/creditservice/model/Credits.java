package com.incekara.creditservice.model;


import java.math.BigDecimal;


public class Credits {

    private Long id;

    private String creditType;

    private BigDecimal selectedAmount;

    private BigDecimal interestRate;

    private  BigDecimal totalCalculateAmount;

    private String environment;

    public Credits() {
    }

    public Credits(Long id, String creditType, BigDecimal selectedAmount, BigDecimal interestRate, BigDecimal totalCalculateAmount, String environment) {
        this.id = id;
        this.creditType = creditType;
        this.selectedAmount = selectedAmount;
        this.interestRate = interestRate;
        this.totalCalculateAmount = totalCalculateAmount;
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

    public BigDecimal getSelectedAmount() {
        return selectedAmount;
    }

    public void setSelectedAmount(BigDecimal selectedAmount) {
        this.selectedAmount = selectedAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getTotalCalculateAmount() {
        return totalCalculateAmount;
    }

    public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
        this.totalCalculateAmount = totalCalculateAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
