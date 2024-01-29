package br.com.pcps.equipamento.equipamento.domain.usecase;

import br.com.pcps.equipamento.equipamento.domain.usecase.response.ConsultaEquipamentosResponse;

public interface ConsultaEquipamentosPorIdUseCase  {

    ConsultaEquipamentosResponse buscarPor(Integer id);

}