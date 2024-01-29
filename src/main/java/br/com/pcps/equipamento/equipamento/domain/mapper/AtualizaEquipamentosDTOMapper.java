package br.com.pcps.equipamento.equipamento.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.dto.AtualizaEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.AtualizaEquipamentosRequest;


@Mapper(componentModel = "spring")
public interface AtualizaEquipamentosDTOMapper{

    AtualizaEquipamentosDTOMapper INSTANCE = Mappers.getMapper( AtualizaEquipamentosDTOMapper.class );

    AtualizaEquipamentosDTO toDTO(AtualizaEquipamentosRequest request);

}
