package com.fatec.SS;

public record EnderecoDTO(
    String cep,
    String logradouro,
    String bairro,
    String localidade,
    String uf
) {}
