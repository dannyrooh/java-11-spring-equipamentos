package br.com.pcps.equipamento.equipamento.infra.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.dto.CadastraEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.infra.jpa.entity.EquipamentosJpa; 

@Mapper(componentModel = "spring")
public interface CadastraEquipamentosJpaMapper {

    CadastraEquipamentosJpaMapper  INSTANCE = Mappers.getMapper( CadastraEquipamentosJpaMapper .class );


    EquipamentosJpa toJpa(CadastraEquipamentosDTO dto);

}

