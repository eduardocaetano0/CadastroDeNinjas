package dev.java10x.cadastrodeninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de boas vindas",description = "Rota de mensagem de boas vindas")
    public String boasVindas(){
        return "Boas vindas";
    }

    //add ninja(CREATE)
    @PostMapping("/criar")//@RequestBody ->
    @Operation(summary = "Cria um Ninja")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })

    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " (ID): "+ novoNinja.getId());
    }

    //mostrar ninjas(READ)
    @GetMapping("/listar")
    @Operation(summary = "lista os ninjas presentes no banco de dados")
    public ResponseEntity<List<NinjaDTO>> listarTodos(){
        List<NinjaDTO> ninjas = ninjaService.listarNinja();
        return ResponseEntity.ok(ninjas);
    }

    //mostrar ninja por id(READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por ID")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Ninja listado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro! Ninja não encontrado.")
    })
    public ResponseEntity<?> listarTodosID(@PathVariable Long id){
        NinjaDTO ninjas = ninjaService.alistarNinjaPorId(id);
        if(ninjas != null){
            return  ResponseEntity.ok().body("Ninja do (ID):"+id+" Atualizado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja do (ID):"+id+"Não foi encontrado!");
        }
    }

    //alterar dados ninja(UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um Ninja por ID")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Ninja alterado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro! Ninja não encontrado.")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o id no path no caminho da requisição")
            @PathVariable long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado na documentação")
            @RequestBody NinjaDTO ninjaAtt){
        NinjaDTO ninjasAlterar = ninjaService.atualizarNinja(id, ninjaAtt);
        if(ninjasAlterar != null){
            return ResponseEntity.ok("Ninja do (ID):"+id+" Atualizado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja do (ID):"+id+"Não foi encontrado! ");
        }
    }

    //deletar ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta Ninja por ID")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Ninja deletado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro! Ninja não encontrado.")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.alistarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja do (ID): "+id +" Deletado com sucesso!");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja do (ID):"+id +" não encontrado!");

    }
}
