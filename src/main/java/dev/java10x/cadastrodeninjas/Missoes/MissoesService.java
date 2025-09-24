package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }
    //Criar missoes
    public MissoesModel criarMissoes(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    //Deletar missoes
    public void deletarMissoes(Long id){
        missoesRepository.deleteById(id);
    }

    //alterar missoes
    public MissoesDTO alterarMissoesPorId(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
           MissoesModel  missaoAlterada = missoesMapper.map(missoesDTO);
           missaoAlterada.setId(id);
           MissoesModel missaoSalvo = missoesRepository.save(missaoAlterada);
           return missoesMapper.map(missaoSalvo);
        }
        return null;
    }
}
