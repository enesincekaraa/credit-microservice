package com.incekara.creditservice.controller;


import com.incekara.creditservice.model.Credits;
import com.incekara.creditservice.proxy.CreditsProxy;
import com.incekara.creditservice.proxy.CreditsProxyV1;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration{
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}


@RestController
public class CreditController {

    private  final CreditsProxy creditsProxy;
    private  final CreditsProxyV1 creditsProxyV1;
    private final  RestTemplate restTemplate;

    public CreditController(CreditsProxy creditsProxy, CreditsProxyV1 creditsProxyV1, RestTemplate restTemplate) {
        this.creditsProxy = creditsProxy;
        this.creditsProxyV1 = creditsProxyV1;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/credit-service-feign/creditType/{creditType}/selectedAmount/{selectedAmount}")

    public Credits creditController(
            @PathVariable String creditType,
            @PathVariable BigDecimal selectedAmount
            ) {
        Credits credits=creditsProxy.retrieveExchangeValue(creditType);

        return new Credits(credits.getId(), creditType,selectedAmount,credits.getInterestRate(),
                selectedAmount.multiply(credits.getInterestRate()), credits.getEnvironment()
        + " " +" feign ");

    }
    @GetMapping("/credit-service-feign-high/creditType/{creditType}/selectedAmount/{selectedAmount}")

    public Credits creditControllerHigh(
            @PathVariable String creditType,
            @PathVariable BigDecimal selectedAmount
    ) {
        Credits credits=creditsProxyV1.retrieveExchangeValue(creditType);

        return new Credits(credits.getId(), creditType,selectedAmount,credits.getInterestRate(),
                selectedAmount.multiply(credits.getInterestRate()), credits.getEnvironment()
                + " " +" feign ");

    }



}
