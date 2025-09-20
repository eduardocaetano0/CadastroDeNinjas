package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinja(){
        return ninjaRepository.findAll();
    }

    //listar por id
    public NinjaModel alistarNinjaPorId(Long id){
        Optional<NinjaModel>ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

   //Criar ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // deletar ninja - tem que ser void
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    //alterar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtt){
        Optional<NinjaModel>atualizarPorId = ninjaRepository.findById(id);
        if(ninjaRepository.existsById(id)){
            ninjaAtt.setId(id);
            return ninjaRepository.save(ninjaAtt);
        }
        return null;
    }
}
