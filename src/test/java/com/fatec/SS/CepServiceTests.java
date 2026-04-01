package com.fatec.SS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CepServiceTest {

  private final CepService cepService = new CepService();

  @Test
  @DisplayName("Deve retornar os dados corretos para um CEP válido")
  void testeRetornarEnderecoCorreto() {
    String cep = "01001000";
    EnderecoDTO enderecoIdeal = new EnderecoDTO(cep, "Praça da Sé", "Sé", "São Paulo", "SP");
    EnderecoDTO resultado = cepService.buscarEndereco(cep);
    assertNotNull(resultado);
    assertEquals(enderecoIdeal.logradouro(), resultado.logradouro());
    assertEquals(enderecoIdeal.bairro(), resultado.bairro());
    assertEquals(enderecoIdeal.localidade(), resultado.localidade());
    assertEquals(enderecoIdeal.uf(), resultado.uf());
  }

  @Test
  @DisplayName("Deve retornar o logradouro correto")
  void testeReal_DeveRetornarLogradouroCorreto() {
    String cep = "01001000";

    EnderecoDTO resultado = cepService.buscarEndereco(cep);

    assertNotNull(resultado, "O resultado não deveria ser nulo");
    assertEquals("Praça da Sé", resultado.logradouro());
  }

  @Test
  @DisplayName("Deve retornar o bairro correto")
  void testeReal_DeveRetornarBairroCorreto() {
    String cep = "01001000";

    EnderecoDTO resultado = cepService.buscarEndereco(cep);

    assertNotNull(resultado, "O resultado não deveria ser nulo");
    assertEquals("Sé", resultado.bairro());
  }

  @Test
  @DisplayName("Deve retornar a localidade correta")
  void testeReal_DeveRetornarLocalidadeCorreta() {
    String cep = "01001000";

    EnderecoDTO resultado = cepService.buscarEndereco(cep);

    assertNotNull(resultado, "O resultado não deveria ser nulo");
    assertEquals("São Paulo", resultado.localidade());
  }

  @Test
  @DisplayName("Deve retornar o uf correto")
  void testeReal_DeveRetornarUfCorreto() {
    String cep = "01001000";

    EnderecoDTO resultado = cepService.buscarEndereco(cep);

    assertNotNull(resultado, "O resultado não deveria ser nulo");
    assertEquals("SP", resultado.uf());
  }

}
