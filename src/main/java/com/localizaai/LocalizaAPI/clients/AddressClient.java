package com.localizaai.LocalizaAPI.clients;

import com.localizaai.LocalizaAPI.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "addressClient", url = "https://brasilapi.com.br/api/cep/v2")
public interface AddressClient {
    @GetMapping("/{cep}")
    Address findByCEP(@PathVariable("cep") String cep);
}
