package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar") //----------> Mandar uma requisição para mostras as missões
    public String listarMissoes(){
        return "Missões listadas com sucesso";
    }
    @PostMapping("/criar")//----------> Mandar uma requisição para criar as missões
    public String criarMissao(){
        return "Missão criada com sucesso";
    }
    @PutMapping("/alterar")//---------->Mandar uma requisição para alterar as missões
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }
    @DeleteMapping("/deletar")//---------->Mandar uma requisição para deletar as missões
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

}
