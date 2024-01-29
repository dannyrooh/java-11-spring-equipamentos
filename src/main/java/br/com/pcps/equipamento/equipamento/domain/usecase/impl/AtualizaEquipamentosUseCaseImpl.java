package br.com.pcps.equipamento.equipamento.domain.usecase.impl;

import br.com.pcps.equipamento.equipamento.domain.gateway.EquipamentosGateway;
import br.com.pcps.equipamento.equipamento.domain.mapper.AtualizaEquipamentosDTOMapper;
import br.com.pcps.equipamento.equipamento.domain.usecase.AtualizaEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.AtualizaEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.AtualizaEquipamentosResponse;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.mapper.AtualizaEquipamentosResponseMapper;

import org.springframework.stereotype.Component;

@Component
public class AtualizaEquipamentosUseCaseImpl implements AtualizaEquipamentosUseCase {

    private final EquipamentosGateway gateway;

    public AtualizaEquipamentosUseCaseImpl(final EquipamentosGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public AtualizaEquipamentosResponse atualizar(AtualizaEquipamentosRequest request) {
     
        var dto = AtualizaEquipamentosDTOMapper.INSTANCE.toDTO(request);

        var entity = gateway.atualizar(dto);

        return AtualizaEquipamentosResponseMapper.INSTANCE.toResponse(entity);

    }

}
