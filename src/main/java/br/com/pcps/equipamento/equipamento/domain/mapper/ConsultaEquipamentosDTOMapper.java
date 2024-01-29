package br.com.pcps.equipamento.equipamento.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.dto.ConsultaEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.ConsultaEquipamentosRequest;

@Mapper(componentModel = "spring")
public interface ConsultaEquipamentosDTOMapper {

    ConsultaEquipamentosDTOMapper INSTANCE = Mappers.getMapper(ConsultaEquipamentosDTOMapper.class);

    ConsultaEquipamentosDTO toDTO(ConsultaEquipamentosRequest request);

}
