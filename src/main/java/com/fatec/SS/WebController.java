package com.fatec.SS;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private final CepService cepService;

    public WebController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoDTO> getEndereco(@PathVariable String cep) {
        try {
            return ResponseEntity.ok(cepService.buscarEndereco(cep));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cep}/logradouro")
    public ResponseEntity<String> getLogradouro(@PathVariable String cep) {
        try {
            return ResponseEntity.ok(cepService.buscarEndereco(cep).logradouro());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cep}/bairro")
    public ResponseEntity<String> getBairro(@PathVariable String cep) {
        try {
            return ResponseEntity.ok(cepService.buscarEndereco(cep).bairro());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cep}/localidade")
    public ResponseEntity<String> getLocalidade(@PathVariable String cep) {
        try {
            return ResponseEntity.ok(cepService.buscarEndereco(cep).localidade());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{cep}/uf")
    public ResponseEntity<String> getUf(@PathVariable String cep) {
        try {
            return ResponseEntity.ok(cepService.buscarEndereco(cep).uf());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
