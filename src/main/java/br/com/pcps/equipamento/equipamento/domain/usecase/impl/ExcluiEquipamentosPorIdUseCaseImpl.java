package br.com.pcps.equipamento.equipamento.domain.usecase.impl;

import br.com.pcps.equipamento.equipamento.domain.gateway.EquipamentosGateway;

import br.com.pcps.equipamento.equipamento.domain.usecase.ExcluiEquipamentosPorIdUseCase;
import br.com.pcps.equipamento.exception.BusinessException;

import org.springframework.stereotype.Component;

@Component
public class ExcluiEquipamentosPorIdUseCaseImpl implements ExcluiEquipamentosPorIdUseCase {

    private final EquipamentosGateway gateway;

    public ExcluiEquipamentosPorIdUseCaseImpl(final EquipamentosGateway gateway) {

        this.gateway = gateway;

    }

    @Override
    public void excluirPor(Integer id) {

        var excluido = this.gateway.excluirPor(id);
        if (!excluido) {
            throw new BusinessException();
        }
    }

}
