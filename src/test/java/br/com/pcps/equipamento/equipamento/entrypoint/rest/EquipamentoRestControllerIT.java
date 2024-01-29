package br.com.pcps.equipamento.equipamento.entrypoint.rest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import br.com.pcps.equipamento.equipamento.domain.usecase.AtualizaEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.CadastraEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.ConsultaEquipamentosPorIdUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.ConsultaEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.ExcluiEquipamentosPorIdUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.AtualizaEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.CadastraEquipamentosRequest;

@ExtendWith(MockitoExtension.class)
class EquipamentosRestControllerTest {

    @InjectMocks
	private EquipamentosRestController controller;
    
    @Mock
    private CadastraEquipamentosUseCase usecase_cadastra;

    @Mock
    private AtualizaEquipamentosUseCase usecase_atualiza;

    @Mock
    private ConsultaEquipamentosUseCase usecase_busca;

    @Mock
    private ConsultaEquipamentosPorIdUseCase usecase_buscaporid;

    @Mock
    private ExcluiEquipamentosPorIdUseCase usecase_delete;

    @DisplayName("Deve realizar o cadastro com sucesso")
    @Test
    void shouldInsertWithSuccess() {
        var date =  Calendar.getInstance().getTime();
		var response = controller.cadastrar( new CadastraEquipamentosRequest("Modelo", "Nome", date , "Descricao",1,1,1));

		assertNotNull(response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

    @DisplayName("Deve realizar a alteração com sucesso")
    @Test
	void shouldUpdateWithSuccess() {
        var date =  Calendar.getInstance().getTime();
		var response = controller.atualizar( new AtualizaEquipamentosRequest(1,"Modelo", "Nome", date , "Descricao",1,1,1));

		assertNotNull(response);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
    
    @DisplayName("Deve realizar a exclusão com sucesso")
    @Test
	void shouldDeleteWithSuccess() {
		var response = controller.excluirPor(1);

		assertNotNull(response);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

    @DisplayName("Deve realizar a busca por id com sucesso")
    @Test
	void shouldSearchForIdWithSuccess() {
		
        var response = controller.buscarPor(1);

		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

    @DisplayName("Deve realizar a busca com paginação com sucesso")
    @Test
	void shouldSearchWithSuccess() {

        var response = controller.buscar(1,null,Pageable.unpaged());
		
        assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}
