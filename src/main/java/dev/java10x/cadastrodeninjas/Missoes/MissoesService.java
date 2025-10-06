package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas as missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar Missoes Por Id
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel>listarPorId = missoesRepository.findById(id);
        return listarPorId.map(missoesMapper::map).orElse(null);
    }

    //Criar missoes
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
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
