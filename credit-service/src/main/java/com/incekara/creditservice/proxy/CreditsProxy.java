package com.incekara.creditservice.proxy;

import com.incekara.creditservice.model.Credits;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "low-interest")
public interface CreditsProxy {

    @GetMapping("/low-interest/creditType/{creditType}")

    public Credits retrieveExchangeValue(@PathVariable String creditType);
}
