package br.com.pcps.equipamento.equipamento.entrypoint.rest;

import br.com.pcps.equipamento.equipamento.domain.usecase.AtualizaEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.CadastraEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.ConsultaEquipamentosUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.ConsultaEquipamentosPorIdUseCase;
import br.com.pcps.equipamento.equipamento.domain.usecase.ExcluiEquipamentosPorIdUseCase;

import br.com.pcps.equipamento.equipamento.domain.usecase.request.AtualizaEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.CadastraEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.request.ConsultaEquipamentosRequest;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.CadastraEquipamentosResponse;
import br.com.pcps.equipamento.equipamento.domain.usecase.response.ConsultaEquipamentosResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("equipamentos")
@Tag(name = "equipamentos", description = "Cadastro das equipamentos")
public class EquipamentosRestController {

    private final CadastraEquipamentosUseCase usecaseCadastra;
    private final AtualizaEquipamentosUseCase uasecaseAutaliza;
    private final ConsultaEquipamentosUseCase usecaseConsulta;
    private final ConsultaEquipamentosPorIdUseCase usecaseConsultaporid;
    private final ExcluiEquipamentosPorIdUseCase uescaseDelete;

    public EquipamentosRestController(final CadastraEquipamentosUseCase usecaseCadastra,
                              final AtualizaEquipamentosUseCase uasecaseAutaliza,
                              final ConsultaEquipamentosUseCase usecaseConsulta,
                              final ConsultaEquipamentosPorIdUseCase usecaseConsultaporid,
                              final ExcluiEquipamentosPorIdUseCase uescaseDelete) {
        this.usecaseCadastra = usecaseCadastra;
        this.uasecaseAutaliza = uasecaseAutaliza;
        this.usecaseConsulta = usecaseConsulta;
        this.usecaseConsultaporid = usecaseConsultaporid;
        this.uescaseDelete = uescaseDelete;
    }

    @Operation(summary = "Cadastrar equipamentos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso", 
                content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CadastraEquipamentosResponse.class)) }),
        @ApiResponse(responseCode = "400", description = "Erro de validação no entrada de dados", content = @Content) ,
        @ApiResponse(responseCode = "422", description = "Erro de negócio ao cadastrar equipamentos", content = @Content) })        
    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody final CadastraEquipamentosRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(usecaseCadastra.cadastrar(request));

    }

    @Operation(summary = "Atualizar equipamentos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Atualização realizada com sucesso", content = @Content ),
            @ApiResponse(responseCode = "400", description = "Erro de validação no entrada de dados", content = @Content) ,
            @ApiResponse(responseCode = "417", description = "Registro não encontrado", content = @Content),
			@ApiResponse(responseCode = "422", description = "Erro de negócio ao alterar o registro", content = @Content) })
    @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> atualizar(@Valid @RequestBody final AtualizaEquipamentosRequest request) {

       uasecaseAutaliza.atualizar(request);
       return ResponseEntity.noContent().build();

    }

	@Operation(summary = "Excluir equipamentos a partir do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Informação adicional excluída", content = @Content),
            @ApiResponse(responseCode = "400", description = "Id zero ou negativo", content = @Content) ,
            @ApiResponse(responseCode = "417", description = "Registro não encontrado", content = @Content),
			@ApiResponse(responseCode = "422", description = "Erro de negócio ao excluir equipamentos", content = @Content) })    
    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> excluirPor(@PathVariable Integer id) {

        uescaseDelete.excluirPor(id);
        return ResponseEntity.noContent().build();

    }

    @Operation(summary = "Consultar equipamentos a partir do seu ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "equipamentos encontrado", content = {
			@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsultaEquipamentosResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Id zero ou negativo", content = @Content) ,
			@ApiResponse(responseCode = "417", description = "Registro não encontrado", content = @Content) })    
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> buscarPor(@PathVariable Integer id) {

        return ResponseEntity.ok(usecaseConsultaporid.buscarPor(id));

    }

    @Operation(summary = "Consultar  equipamentos, filtrando por {id}, nome")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Encontrada uma ou mais equipamentos", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ConsultaEquipamentosResponse.class)))
        }),
        @ApiResponse(responseCode = "204", description = "Nenhum registro encontrado", content = @Content) 
    })
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> buscar(
        @RequestParam(value = "id", defaultValue = "0") Integer id,
        @RequestParam(value = "nome", defaultValue = "") String nome,
        @ParameterObject @PageableDefault(page = 0, size = 10) Pageable paginacao) {

        var request = ConsultaEquipamentosRequest.builder()
                       .id(id) 
                       .nome(nome)
                       .paginacao(paginacao)
                       .build();

        return ResponseEntity.ok(usecaseConsulta.buscar(request));

    }




}