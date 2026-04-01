package com.fatec.SS;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CepService {

    private final RestClient restClient;

    public CepService() {
        this.restClient = RestClient.create("https://viacep.com.br/ws/");
    }

    public EnderecoDTO buscarEndereco(String cep) {
        // A lógica de negócio e consumo de API fica aqui
        return restClient.get()
                .uri("{cep}/json", cep)
                .retrieve()
                .body(EnderecoDTO.class);
    }
}
