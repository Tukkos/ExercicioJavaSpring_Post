package com.carsapi.api.DTO;

public record CarDTO(
    String modelo,
    String fabricante,
    String data_fabricacao,
    int valor,
    int ano_modelo
    ) {
}
