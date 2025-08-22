package dev.java10x.cadastrodeninjas.Missoes;


import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private char dificuldade;

    //@OneToMany --> uma missão para muitos ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    public MissoesModel() {
    }
    public MissoesModel(char dificuldade, String nome) {
        this.dificuldade = dificuldade;
        this.nome = nome;
    }

    public char getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(char dificuldade) {
        this.dificuldade = dificuldade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nomeD) {
        this.nome = nome;
    }
}
