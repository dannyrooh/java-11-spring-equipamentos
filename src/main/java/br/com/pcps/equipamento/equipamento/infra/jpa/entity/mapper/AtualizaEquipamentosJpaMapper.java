package br.com.pcps.equipamento.equipamento.infra.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.dto.AtualizaEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.infra.jpa.entity.EquipamentosJpa;


@Mapper(componentModel = "spring")
public interface AtualizaEquipamentosJpaMapper{

    AtualizaEquipamentosJpaMapper INSTANCE = Mappers.getMapper( AtualizaEquipamentosJpaMapper.class );

    EquipamentosJpa toJpa(AtualizaEquipamentosDTO dto);

}
