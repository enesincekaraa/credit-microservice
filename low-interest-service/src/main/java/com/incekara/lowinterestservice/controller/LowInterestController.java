package com.incekara.lowinterestservice.controller;

import com.incekara.lowinterestservice.model.LowInterest;
import com.incekara.lowinterestservice.repository.LowInterestRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LowInterestController {

    private final Environment environment;

    private  final LowInterestRepository repository;


    public LowInterestController(Environment environment, LowInterestRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/low-interest/creditType/{creditType}")

    public LowInterest retrieveExchangeValue(@PathVariable String creditType){
        LowInterest lowInterest=repository.findByCreditType(creditType);

        if (lowInterest==null){
            throw new RuntimeException("Unable to find data for" + creditType);
        }

        String port=environment.getProperty("local.server.port");
        lowInterest.setEnvironment(port);
        return lowInterest;
    }
}
