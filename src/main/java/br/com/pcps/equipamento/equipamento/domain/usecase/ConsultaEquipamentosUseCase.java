package br.com.pcps.equipamento.equipamento.domain.usecase;

import org.springframework.data.domain.Page;

import br.com.pcps.equipamento.equipamento.domain.usecase.response.ConsultaEquipamentosResponse;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.ConsultaEquipamentosRequest;

public interface ConsultaEquipamentosUseCase {

    Page<ConsultaEquipamentosResponse> buscar(ConsultaEquipamentosRequest request);

}

