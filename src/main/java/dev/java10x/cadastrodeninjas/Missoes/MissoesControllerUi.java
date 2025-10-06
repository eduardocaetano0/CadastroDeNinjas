package dev.java10x.cadastrodeninjas.Missoes;



import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {
    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes"; //retornar o nome da pag que renderiza
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissoes(id);
        return "redirect:/missoes/ui/listar";
    }

    // Esse aqui é para detalhes VV
    @GetMapping("/listar/{id}")
    public String alterarMissaoPorId(@PathVariable Long id, Model model) {
        MissoesDTO missoes = missoesService.listarMissoesPorId(id);
        if (missoes != null) {
            model.addAttribute("missao", missoes);
            return "detalhesMissao";
        } else
            model.addAttribute("Mensagem", "Missão Não encontrada");
        return "listarMissoes";
    }
}