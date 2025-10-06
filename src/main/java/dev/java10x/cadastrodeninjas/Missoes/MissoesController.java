package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar") //----------> Mandar uma requisição para mostras as missões
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> listarMissao = missoesService.listarMissoes();
        return ResponseEntity.ok().body(listarMissao);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        MissoesDTO missoesDTO = missoesService.listarMissoesPorId(id);
        if(missoesDTO != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão do (ID):"+id+" Atualizada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada!");
        }
    }

    @PostMapping("/criar")//----------> Mandar uma requisição para criar as missões
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes){
        MissoesDTO novaMissao = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão de (ID): "+ novaMissao.getId()+" criada com sucesso!");
    }

    @PutMapping("/alterar/{id}")//---------->Mandar uma requisição para alterar as missões
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missoes){
        MissoesDTO alteraMissaoId = missoesService.alterarMissoesPorId(id, missoes);
        if(alteraMissaoId != null){

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão alterada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão do (ID): "+id+" Não encontrada!");
        }
    }

    @DeleteMapping("/deletar/{id}")//---------->Mandar uma requisição para deletar as missões
    public ResponseEntity<?> deletarMissao(@PathVariable Long id){
        MissoesDTO deletaMissao = missoesService.listarMissoesPorId(id);
        if(deletaMissao != null){
            return ResponseEntity.ok("Missão de (ID): "+id+" deletada com sucesso!");
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão do (ID):"+id +" não encontrada!\"");
        }
    }
}
