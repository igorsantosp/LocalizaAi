package com.localizaai.LocalizaAPI.clients.brasilapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "addressClient", url = "https://brasilapi.com.br/api/cep/v2")
public interface BrasilAPIAddressClient {
    @GetMapping("/{cep}")
    BrasilAPIAddress findByCEP(@PathVariable("cep") String cep);
}
