package br.com.pcps.equipamento.equipamento.domain.gateway;


import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.pcps.equipamento.equipamento.domain.entity.Equipamentos;
import br.com.pcps.equipamento.equipamento.domain.dto.AtualizaEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.domain.dto.CadastraEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.domain.dto.ConsultaEquipamentosDTO;

public interface EquipamentosGateway {
    
	Equipamentos salvar(CadastraEquipamentosDTO dto);

	Page<Equipamentos> buscar(ConsultaEquipamentosDTO dto);

	Optional<Equipamentos> buscarPor(Integer id);

	Equipamentos atualizar(AtualizaEquipamentosDTO dto);

	boolean excluirPor(Integer id);    

}