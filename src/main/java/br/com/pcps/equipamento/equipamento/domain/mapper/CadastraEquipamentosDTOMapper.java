package br.com.pcps.equipamento.equipamento.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.dto.CadastraEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.CadastraEquipamentosRequest; 

@Mapper(componentModel = "spring")
public interface CadastraEquipamentosDTOMapper{

    CadastraEquipamentosDTOMapper INSTANCE = Mappers.getMapper( CadastraEquipamentosDTOMapper.class );
    
    CadastraEquipamentosDTO toDTO(CadastraEquipamentosRequest request);

}

