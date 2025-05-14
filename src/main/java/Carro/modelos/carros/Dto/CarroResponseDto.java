package Carro.modelos.carros.Dto;

import lombok.Data;

@Data
public class CarroResponseDto {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private Integer ano;

}
