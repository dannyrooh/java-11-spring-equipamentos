package br.com.pcps.equipamento.equipamento.infra.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import br.com.pcps.equipamento.equipamento.infra.jpa.entity.EquipamentosJpa;

@DataJpaTest
class EquipamentosRepositoryTest {

    @Autowired
    private EquipamentosRepository equipamentosRepository;


    @Test
    @DisplayName("Testa o save e findById")
    void testSaveAndFind() {
        
        var id = insertOneEquipamento();
        var result = equipamentosRepository.findById(id);
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Testa o deleteById")
    void testDelete() {
        
        var id = insertOneEquipamento();
        equipamentosRepository.deleteById(id);

        var result = equipamentosRepository.findById(id);
        assertThat(result).isNotNull();

    }    

    @Test
    @DisplayName("Testa o update")
    void testUpdate() {
        
        var id = insertOneEquipamento();
        Optional<EquipamentosJpa> equipamento = equipamentosRepository.findById(id);

        equipamento.get().setDescricao("update descrição");
        equipamentosRepository.save(equipamento.get());

        Optional<EquipamentosJpa> result = equipamentosRepository.findById(id);

        assertEquals(equipamento.get().getDescricao(), result.get().getDescricao());
   }    


    @Test
    @DisplayName("Testa a busca pelo nome do equipamento")
    void testBuscarEquipamentos() throws ParseException {
        
        var n = 3;
        insertEquipamentoJPA(n);

        Integer id = null; 
        String nome = "Equipamento"; 
        Pageable pageable = PageRequest.of(0, 10);

        Page<EquipamentosJpa> result = equipamentosRepository.buscar(id, nome, pageable);

        assertThat(result).isNotNull();
        assertEquals(n, result.getTotalElements());

    }

    @Test
    @DisplayName("Testa a busca pelo nome sem informar parâmentros")
    void testBuscarEquipamentosFiltroNull() throws ParseException {
        
        var n = 6;
        insertEquipamentoJPA(n);

        Integer id = null; 
        String nome = null; 
        Pageable pageable = PageRequest.of(0, 10);

        Page<EquipamentosJpa> result = equipamentosRepository.buscar(id, nome, pageable);

        assertThat(result).isNotNull();
        assertEquals(n, result.getTotalElements());

    }


    private List<EquipamentosJpa> insertEquipamentoJPA(Integer n){

        List<EquipamentosJpa> equipamentosList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String modelo = "Modelo" + i;
            String nome = "Equipamento" + i;
            String dataString = "2022-01-01";

            EquipamentosJpa equipamento;
            try {
                equipamento = criarEquipamento(modelo, nome, dataString);
                equipamentosList.add(equipamento);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
        }

        equipamentosRepository.saveAll(equipamentosList);

        return equipamentosList;

    }

    private Integer insertOneEquipamento() {
                
        List<EquipamentosJpa> equipamentosList = insertEquipamentoJPA(1);
        
        if (!equipamentosList.isEmpty()) {
            EquipamentosJpa equipamento = equipamentosList.get(0);
            return equipamento.getId();
        } else {
            return 0;
        }

    }

    private EquipamentosJpa criarEquipamento(String modelo, String nome, String dataEntrada) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dataEntrada);

        EquipamentosJpa equipamento = new EquipamentosJpa();
        equipamento.setModelo(modelo);
        equipamento.setNome(nome);
        equipamento.setEntrada(date); 
        equipamento.setDescricao("Descrição do equipamento");
        equipamento.setEmpresa(1);
        equipamento.setFilial(1);
        equipamento.setIdEmpresa(1);
        return equipamento;
    }
}