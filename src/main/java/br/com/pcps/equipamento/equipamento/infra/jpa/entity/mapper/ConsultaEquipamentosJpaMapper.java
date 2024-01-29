
package br.com.pcps.equipamento.equipamento.infra.jpa.entity.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pcps.equipamento.equipamento.domain.dto.ConsultaEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.infra.jpa.entity.EquipamentosJpa;

@Mapper(componentModel = "spring")
public interface ConsultaEquipamentosJpaMapper {

    ConsultaEquipamentosJpaMapper INSTANCE = Mappers.getMapper(ConsultaEquipamentosJpaMapper.class);

    EquipamentosJpa toJpa(ConsultaEquipamentosDTO dto);

    List<EquipamentosJpa> toJpaList(List<ConsultaEquipamentosDTO> dto);

}
