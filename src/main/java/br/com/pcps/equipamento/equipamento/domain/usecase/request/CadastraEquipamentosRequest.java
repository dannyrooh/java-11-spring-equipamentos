package br.com.pcps.equipamento.equipamento.domain.usecase.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastraEquipamentosRequest {

    
    private String modelo;

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd")
    private Date entrada;

    private String descricao;

    private Integer empresa;

    private Integer filial;

    private Integer idEmpresa;

}