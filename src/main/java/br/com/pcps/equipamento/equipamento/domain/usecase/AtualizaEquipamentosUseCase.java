package br.com.pcps.equipamento.equipamento.domain.usecase;

import br.com.pcps.equipamento.equipamento.domain.usecase.request.AtualizaEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.AtualizaEquipamentosResponse;

public interface AtualizaEquipamentosUseCase {

    AtualizaEquipamentosResponse atualizar(AtualizaEquipamentosRequest request);

}