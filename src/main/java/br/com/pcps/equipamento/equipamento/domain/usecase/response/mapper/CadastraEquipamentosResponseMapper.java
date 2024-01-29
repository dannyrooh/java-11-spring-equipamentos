package br.com.pcps.equipamento.equipamento.domain.usecase.response.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.entity.Equipamentos;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.CadastraEquipamentosResponse;

@Mapper(componentModel = "spring")
public interface CadastraEquipamentosResponseMapper {

    CadastraEquipamentosResponseMapper INSTANCE = Mappers.getMapper(CadastraEquipamentosResponseMapper.class);

    CadastraEquipamentosResponse toResponse(Equipamentos entity);

}
