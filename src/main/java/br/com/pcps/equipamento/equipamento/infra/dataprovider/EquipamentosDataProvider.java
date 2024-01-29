package br.com.pcps.equipamento.equipamento.infra.dataprovider;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.pcps.equipamento.equipamento.domain.entity.Equipamentos;
import br.com.pcps.equipamento.equipamento.domain.dto.AtualizaEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.domain.dto.CadastraEquipamentosDTO;
import br.com.pcps.equipamento.equipamento.domain.dto.ConsultaEquipamentosDTO;

import br.com.pcps.equipamento.equipamento.domain.gateway.EquipamentosGateway;
import br.com.pcps.equipamento.equipamento.infra.jpa.entity.mapper.AtualizaEquipamentosJpaMapper;
import br.com.pcps.equipamento.equipamento.infra.jpa.entity.mapper.CadastraEquipamentosJpaMapper;
import br.com.pcps.equipamento.equipamento.infra.jpa.repository.EquipamentosRepository;
import br.com.pcps.equipamento.equipamento.infra.mapper.EquipamentosMapper;

@Component
class EquipamentosDataProvider implements EquipamentosGateway {

    private final EquipamentosRepository repository;

    public EquipamentosDataProvider(final EquipamentosRepository repository){
        this.repository = repository;
    }
    
    @Override
	public Equipamentos salvar(CadastraEquipamentosDTO dto){

        var jpa = CadastraEquipamentosJpaMapper.INSTANCE.toJpa(dto);

        var model = repository.save(jpa);

        return EquipamentosMapper.INSTANCE.toEntity(model);  

    }

    @Override
	public Page<Equipamentos> buscar(ConsultaEquipamentosDTO dto){

        return  repository.buscar( dto.getId(), 
                                   dto.getNome(),
                                   dto.getPaginacao())
                            .map(EquipamentosMapper.INSTANCE::toEntity);


    }

    @Override
	public Optional<Equipamentos> buscarPor(Integer id){

        var optional = repository.findById(id);

		if (optional.isPresent()) {
			return Optional.ofNullable(EquipamentosMapper.INSTANCE.toEntity(optional.get()));
		} else {
			return Optional.empty();
		}
    }

    @Override
	public Equipamentos atualizar(AtualizaEquipamentosDTO dto){

        var jpa = AtualizaEquipamentosJpaMapper.INSTANCE.toJpa(dto);

        var model = repository.save(jpa);

        return EquipamentosMapper.INSTANCE.toEntity(model);  

    }

    @Override   
	public boolean excluirPor(Integer id){

        repository.deleteById(id);

        var optional = repository.findById(id);

        return optional.isEmpty();        

    }    

}