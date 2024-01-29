package br.com.pcps.equipamento.equipamento.domain.usecase.response.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.entity.Equipamentos;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.AtualizaEquipamentosResponse;

@Mapper(componentModel = "spring")
public interface AtualizaEquipamentosResponseMapper {

    AtualizaEquipamentosResponseMapper INSTANCE = Mappers.getMapper( AtualizaEquipamentosResponseMapper.class );

    AtualizaEquipamentosResponse toResponse(Equipamentos entity);

}

