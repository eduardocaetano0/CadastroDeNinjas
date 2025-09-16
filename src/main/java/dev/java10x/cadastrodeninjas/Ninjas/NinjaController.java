package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Boas vindas";
    }

    //add ninja(CREATE)
    @PostMapping("/criar")      //@RequestBody ->
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //mostrar ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarTodos(){
        return ninjaService.listarNinja();
    }

    //mostrar ninja por id(READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarTodosID(@PathVariable Long id){
        return ninjaService.alistarNinjaPorId(id);
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
