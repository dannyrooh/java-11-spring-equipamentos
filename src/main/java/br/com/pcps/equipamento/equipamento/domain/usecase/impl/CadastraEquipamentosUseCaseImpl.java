package br.com.pcps.equipamento.equipamento.domain.usecase.impl;

import br.com.pcps.equipamento.equipamento.domain.gateway.EquipamentosGateway;
import br.com.pcps.equipamento.equipamento.domain.mapper.CadastraEquipamentosDTOMapper;
import br.com.pcps.equipamento.equipamento.domain.usecase.CadastraEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.CadastraEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.CadastraEquipamentosResponse;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.mapper.CadastraEquipamentosResponseMapper;

import org.springframework.stereotype.Component;

@Component
public class CadastraEquipamentosUseCaseImpl implements CadastraEquipamentosUseCase {

    private final EquipamentosGateway gateway;

    public CadastraEquipamentosUseCaseImpl(final EquipamentosGateway gateway) {

        this.gateway = gateway;
        
    }

    @Override
    public CadastraEquipamentosResponse cadastrar(CadastraEquipamentosRequest request) {
     
        var dto = CadastraEquipamentosDTOMapper.INSTANCE.toDTO(request);

        var entity = gateway.salvar(dto);

        return CadastraEquipamentosResponseMapper.INSTANCE.toResponse(entity);
        
    }

}
