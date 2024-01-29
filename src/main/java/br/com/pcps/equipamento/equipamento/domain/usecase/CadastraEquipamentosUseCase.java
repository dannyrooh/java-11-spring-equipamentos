package br.com.pcps.equipamento.equipamento.domain.usecase;

import br.com.pcps.equipamento.equipamento.domain.usecase.request.CadastraEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.CadastraEquipamentosResponse;

public interface CadastraEquipamentosUseCase {

    CadastraEquipamentosResponse cadastrar(CadastraEquipamentosRequest request);

}