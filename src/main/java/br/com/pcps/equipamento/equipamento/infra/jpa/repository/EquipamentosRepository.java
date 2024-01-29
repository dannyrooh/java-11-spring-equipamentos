package br.com.pcps.equipamento.equipamento.infra.jpa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;

import br.com.pcps.equipamento.equipamento.infra.jpa.entity.EquipamentosJpa;

public interface EquipamentosRepository  extends JpaRepository<EquipamentosJpa,  Integer> {

    @Query(value = EquipamentosQueryBusca.SELECT,
            countQuery = EquipamentosQueryBusca.COUNT,
            nativeQuery = true)
    Page<EquipamentosJpa> buscar(
        @Param("id") Integer id,
        @Param("nome") String nome,
        @SortDefaults({
            @SortDefault(sort = "\"PN_Equip\"", direction = Sort.Direction.ASC),
        }) Pageable paginacao );
    

}