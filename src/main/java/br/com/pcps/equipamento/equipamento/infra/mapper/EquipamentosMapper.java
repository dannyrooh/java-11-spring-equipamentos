package br.com.pcps.equipamento.equipamento.infra.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.entity.Equipamentos;
import br.com.pcps.equipamento.equipamento.infra.jpa.entity.EquipamentosJpa;

@Mapper(componentModel = "spring")
public interface EquipamentosMapper {

    EquipamentosMapper INSTANCE = Mappers.getMapper(EquipamentosMapper.class);

    @Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
    public Equipamentos toEntity(EquipamentosJpa jpa);


}
