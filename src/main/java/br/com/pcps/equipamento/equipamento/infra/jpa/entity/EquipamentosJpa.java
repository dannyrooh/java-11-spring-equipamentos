package br.com.pcps.equipamento.equipamento.infra.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"Equipamentos\"")
public class EquipamentosJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Index_Equip\"", nullable = false)
    private Integer id;
    
    @Column(name = "\"Modelo_Equip\"", nullable = false , length = 50)
    private String modelo;
    
    @Column(name = "\"PN_Equip\"", nullable = true , length = 50)
    private String nome;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd")
    @Column(name = "\"Entrada_Equip\"", nullable = false)
    private Date entrada;
    
    @Column(name = "\"Descricao_Equip\"", nullable = false , length = 500)
    private String descricao;
    
    @Column(name = "cd_empresa", nullable = false)
    private Integer empresa;
    
    @Column(name = "cd_filial", nullable = false)
    private Integer filial;
    
    @Column(name = "eqp_empresa", nullable = true)
    private Integer idEmpresa;
    
    

}