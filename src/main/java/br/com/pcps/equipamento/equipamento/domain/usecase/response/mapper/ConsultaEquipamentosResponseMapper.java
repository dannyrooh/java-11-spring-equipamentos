package br.com.pcps.equipamento.equipamento.domain.usecase.response.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.entity.Equipamentos;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.ConsultaEquipamentosResponse;

@Mapper(componentModel = "spring")
public interface ConsultaEquipamentosResponseMapper {

    ConsultaEquipamentosResponseMapper INSTANCE = Mappers.getMapper(ConsultaEquipamentosResponseMapper.class);

    List<ConsultaEquipamentosResponse> toResponseList(List<Equipamentos> entity);

    ConsultaEquipamentosResponse toResponse(Equipamentos entity);

}
