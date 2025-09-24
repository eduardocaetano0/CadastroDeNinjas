package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar") //----------> Mandar uma requisição para mostras as missões
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }
    @PostMapping("/criar")//----------> Mandar uma requisição para criar as missões
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissoes(missoes);
    }
    @PutMapping("/alterar/{id}")//---------->Mandar uma requisição para alterar as missões
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missoes){
        return missoesService.alterarMissoesPorId(id, missoes);
    }
    @DeleteMapping("/deletar")//---------->Mandar uma requisição para deletar as missões
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

}
