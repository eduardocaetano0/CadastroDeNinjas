package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
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
    public NinjaModel criarNinja(NinjaModel  ninja){
        return ninjaRepository.save(ninja);
    }
}
