package dev.java10x.cadastrodeninjas.Ninjas;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarTodos(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinja();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; //retornar o nome da pag que renderiza
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }
    @GetMapping("/listar/{id}")
    public String listarTodosID(@PathVariable Long id, Model model){
        NinjaDTO ninjas = ninjaService.alistarNinjaPorId(id);
        if (ninjas != null){
            model.addAttribute("ninjas", ninjas);
            return "detalhesNinjas";
        } else
            model.addAttribute("Mensagem", "Ninja Não encontrado");
            return "listarNinjas";
    }

    @GetMapping("/adicionar")
    public String mostrarFormulario(Model model){
        model.addAttribute("ninjas", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes, Model model){
        ninjaService.criarNinja(ninja);
        redirectAttributes.addAttribute("mesagem", "Ninja Salvo com sucesso");
        return "redirect:/ninjas/ui/listar";
    }
}
