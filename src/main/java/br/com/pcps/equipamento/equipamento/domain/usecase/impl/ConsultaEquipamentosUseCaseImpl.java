package br.com.pcps.equipamento.equipamento.domain.usecase.impl;

import br.com.pcps.equipamento.equipamento.domain.gateway.EquipamentosGateway;
import br.com.pcps.equipamento.equipamento.domain.mapper.ConsultaEquipamentosDTOMapper;
import br.com.pcps.equipamento.equipamento.domain.usecase.ConsultaEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.ConsultaEquipamentosResponse;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.ConsultaEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.mapper.ConsultaEquipamentosResponseMapper;
import br.com.pcps.equipamento.exception.NoContentException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsultaEquipamentosUseCaseImpl implements ConsultaEquipamentosUseCase {

    private final EquipamentosGateway gateway;

    public ConsultaEquipamentosUseCaseImpl(final EquipamentosGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public Page<ConsultaEquipamentosResponse> buscar(ConsultaEquipamentosRequest request) {

        log.info("Busca tabela Equipamentos com paginação" );
     
        var dto = ConsultaEquipamentosDTOMapper.INSTANCE.toDTO(request);

        var response = gateway.buscar(dto).map(ConsultaEquipamentosResponseMapper.INSTANCE::toResponse);;
        
        if (response.isEmpty()) { throw new NoContentException(); };

        return response;

    }

}
