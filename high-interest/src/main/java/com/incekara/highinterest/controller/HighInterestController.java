package com.incekara.highinterest.controller;

import com.incekara.highinterest.model.HighInterest;
import com.incekara.highinterest.repository.HighInterestRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighInterestController {

    private  final Environment environment;

    private  final HighInterestRepository repository;


    public HighInterestController(Environment environment, HighInterestRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/high-interest/creditType/{creditType}")

    public HighInterest retrieveExchangeValue(@PathVariable String creditType){
        HighInterest highInterest=repository.findByCreditType(creditType);

        if (highInterest==null){
            throw new RuntimeException("Unable to find data for" + creditType);
        }

        String port=environment.getProperty("local.server.port");
        highInterest.setEnvironment(port);
        return highInterest;
    }
}
