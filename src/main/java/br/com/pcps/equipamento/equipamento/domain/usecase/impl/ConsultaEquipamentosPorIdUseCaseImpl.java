package br.com.pcps.equipamento.equipamento.domain.usecase.impl;

import br.com.pcps.equipamento.equipamento.domain.gateway.EquipamentosGateway;
import br.com.pcps.equipamento.equipamento.domain.usecase.ConsultaEquipamentosPorIdUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.ConsultaEquipamentosResponse;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.mapper.ConsultaEquipamentosResponseMapper;
import br.com.pcps.equipamento.exception.NoContentException;

import org.springframework.stereotype.Component;

@Component
public class ConsultaEquipamentosPorIdUseCaseImpl implements ConsultaEquipamentosPorIdUseCase {

    private final EquipamentosGateway gateway;

    public ConsultaEquipamentosPorIdUseCaseImpl(final EquipamentosGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public ConsultaEquipamentosResponse buscarPor( Integer id) {
     
        var optional = gateway.buscarPor(id);

        if (optional.isPresent()) {
            return ConsultaEquipamentosResponseMapper.INSTANCE.toResponse(optional.get());
        } else {
            throw new NoContentException();
        }

    }

}
