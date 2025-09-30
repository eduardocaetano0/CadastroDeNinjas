package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Boas vindas";
    }

    //add ninja(CREATE)
    @PostMapping("/criar")      //@RequestBody ->
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " (ID): "+ novoNinja.getId());
    }

    //mostrar ninjas(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarTodos(){
        List<NinjaDTO> ninjas = ninjaService.listarNinja();
        return ResponseEntity.ok(ninjas);
    }

    //mostrar ninja por id(READ)
    @GetMapping("/listar/{id}")
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
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable long id, @RequestBody NinjaDTO ninjaAtt){
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
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.alistarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja do (ID): "+id +" Deletado com sucesso!");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja do (ID):"+id +" não encontrado!");

    }
}
