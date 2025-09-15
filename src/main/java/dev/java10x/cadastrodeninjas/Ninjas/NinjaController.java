package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Boas vindas";
    }

    //add ninja(CREATE)
    @PostMapping("/criar")
    public String criaNinja(){
        return "Ninja criado";
    }

    //mostrar ninjas(READ)
    @GetMapping("/listar")
    public String mostrarTodos(){
        return "Todos os ninjas";
    }
    //mostrar ninja por id(READ)
    @GetMapping("/listarID")
    public String mostrarTodosID(){
        return "Todos os ninjas por ID";
    }
    //alterar dados ninja(UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alternar ninja por ID";
    }
    //deletar ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }
}
