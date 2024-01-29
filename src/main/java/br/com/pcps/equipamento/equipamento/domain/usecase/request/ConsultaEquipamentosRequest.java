package br.com.pcps.equipamento.equipamento.domain.usecase.request;

import java.util.Date;

import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaEquipamentosRequest {

    private Integer id;

    private String modelo;

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd")
    private Date entrada;

    private String descricao;

    private Integer empresa;

    private Integer filial;

    private Integer idEmpresa;

    private Pageable paginacao;
}