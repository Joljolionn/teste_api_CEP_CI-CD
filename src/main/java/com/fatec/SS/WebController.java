package com.fatec.SS;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;

@Controller
public class WebController {

  private final RestClient restClient;

  public WebController() {
    this.restClient = RestClient.create("https://viacep.com.br/ws/");
  }

  @GetMapping(path = "/{cep}")
  public ResponseEntity<EnderecoDTO> returnEndereco(@PathVariable String cep) {
    try {

      EnderecoDTO endereco = restClient.get().uri("{cep}/json", cep).retrieve().body(EnderecoDTO.class);
      return ResponseEntity.ok(endereco);
    } catch (Exception e) {
      return ResponseEntity.status(500).body(null);
    }
  }

  @GetMapping(path = "/{cep}/logradouro")
  public ResponseEntity<String> returnLogradouro(@PathVariable String cep) {

    try {

      EnderecoDTO endereco = restClient.get().uri("{cep}/json", cep).retrieve().body(EnderecoDTO.class);
      return ResponseEntity.ok(endereco.logradouro());
    } catch (Exception e) {
      return ResponseEntity.status(500).body(null);
    }
  }

  @GetMapping(path = "/{cep}/bairro")
  public ResponseEntity<String> returnBairro(@PathVariable String cep) {

    try {

      EnderecoDTO endereco = restClient.get().uri("{cep}/json", cep).retrieve().body(EnderecoDTO.class);
      return ResponseEntity.ok(endereco.bairro());
    } catch (Exception e) {
      return ResponseEntity.status(500).body(null);
    }
  }

  @GetMapping(path = "/{cep}/localidade")
  public ResponseEntity<String> returnLocalidade(@PathVariable String cep) {

    try {

      EnderecoDTO endereco = restClient.get().uri("{cep}/json", cep).retrieve().body(EnderecoDTO.class);
      return ResponseEntity.ok(endereco.localidade());
    } catch (Exception e) {
      return ResponseEntity.status(500).body(null);
    }
  }

  @GetMapping(path = "/{cep}/uf")
  public ResponseEntity<String> returnUf(@PathVariable String cep) {

    try {

      EnderecoDTO endereco = restClient.get().uri("{cep}/json", cep).retrieve().body(EnderecoDTO.class);
      return ResponseEntity.ok(endereco.uf());
    } catch (Exception e) {
      return ResponseEntity.status(500).body(null);
    }
  }
}
